package com.merca.project.mercaproject.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductEdit {

    private String name;
    private String description;
    private Double price;

    private Long EAN;
}
