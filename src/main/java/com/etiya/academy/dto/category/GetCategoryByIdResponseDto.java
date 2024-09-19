package com.etiya.academy.dto.category;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryByIdResponseDto {
    private int id;
    @NotNull
    @NotBlank
    private String name;
}
