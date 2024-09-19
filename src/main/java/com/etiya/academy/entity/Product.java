package com.etiya.academy.entity;

import com.etiya.academy.core.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Entity {
    private int id;
    private String name;
    private double unitPrice;
    private int unitsInStock;

    private Category category;
}
