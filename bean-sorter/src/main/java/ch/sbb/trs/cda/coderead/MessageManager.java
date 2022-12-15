/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2022.
 */

package ch.sbb.trs.cda.coderead;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MessageManager<K, V> {

    private final Map<K, BlockingQueue<V>> map = new ConcurrentHashMap<>();

    public void register(K key) {
        map.computeIfAbsent(key, k -> new ArrayBlockingQueue<>(1));
    }

    public void unregister(K key) {
        map.remove(key);
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            if (!map.get(key).offer(value)) {
                log.warn("Got multiple messages for key: {} second and following will be ignored", key);
            }
        }
    }

    public V get(K key, long timeout, TimeUnit timeUnit) throws IOException {
        try {
            if (map.containsKey(key)) {
                return map.get(key).poll(timeout, timeUnit);
            }
        } catch (InterruptedException e) {
            throw new IOException("Timeout waiting on response with id " + key);
        }
        return null;
    }
}
