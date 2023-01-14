package com.merca.project.mercaproject.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCreate {

    private String name;
    private String description;
    private Long EAN;
    private Double price;
}
