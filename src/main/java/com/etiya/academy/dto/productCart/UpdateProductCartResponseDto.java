package com.etiya.academy.dto.productCart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductCartResponseDto {

    private int id;
    private int productId;
    private int cartId;
    private int quantity;

}
