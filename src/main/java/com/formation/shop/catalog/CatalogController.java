package com.formation.shop.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final Catalog catalog;

    @PostMapping
    Long create(@RequestParam String name, @RequestParam int price)
    {
        return catalog.createCoffee(name, price);
    }
}
