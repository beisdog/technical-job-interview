/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2022.
 */

package ch.sbb.trs.assessment.springshop.controller;

import ch.sbb.trs.assessment.springshop.entities.ProductEntity;
import ch.sbb.trs.assessment.springshop.entities.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductRepo repo;

    @GetMapping("/")
    public List<ProductEntity> getAll() {
        return this.repo.findAll();
    }
}
