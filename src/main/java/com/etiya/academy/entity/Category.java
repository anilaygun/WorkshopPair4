package com.etiya.academy.entity;

import com.etiya.academy.core.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Entity {
    private int id;
    private String name;

    private List<Product> products;
}
