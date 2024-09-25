package com.etiya.academy.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductByCategoryIdResponseDto {
    private int id;
    private String name;
    private double unitPrice;
    private int unitsInStock;
    private int categoryId;
}
