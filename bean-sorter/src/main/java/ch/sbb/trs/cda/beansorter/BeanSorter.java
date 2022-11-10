/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2022.
 */

package ch.sbb.trs.cda.beansorter;

import lombok.SneakyThrows;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BeanSorter {
    /**
     * Sorts a list of javabeans by a property.
     * @param unsorted -  the unsorted list
     * @param property -  the bean property to use for sorting
     * @param asc - if true it is sorted in ascending order otherwise descending
     * @return sorted list (copy of unsorted)
     * @param <T> the type in the list
     */
    public static <T> List<T> sortByField(List<T> unsorted, String property, boolean asc) {
        return null;
    }
}
