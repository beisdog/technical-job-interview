/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2022.
 */

package ch.sbb.trs.assessment.springshop.entities;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final ProductRepo productRepo;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        for (int i = 1; i < 100; i++) {
            final ProductEntity entity = ProductEntity
                    .builder()
                    .name("Product" + i)
                    .description("Super cool Product" + i)
                    .price(new BigDecimal(String.valueOf(i)))
                    .build();
            this.productRepo.saveAndFlush(entity);
        }
    }
}
