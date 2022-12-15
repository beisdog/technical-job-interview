/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2022.
 */

package ch.sbb.trs.assessment.springshop.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
}
