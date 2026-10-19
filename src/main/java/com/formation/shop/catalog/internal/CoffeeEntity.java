package com.formation.shop.catalog.internal;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

public class CoffeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Getter
    private String name;
    private int price;

    public CoffeeEntity(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    protected CoffeeEntity()
    {};
}
