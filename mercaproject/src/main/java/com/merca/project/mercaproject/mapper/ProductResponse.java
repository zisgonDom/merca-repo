package com.merca.project.mercaproject.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {

    private String name;
    private String description;
    private Long EAN;
    private Double price;
    private Long supplier;
    private String destination;
    private Long productCode;
}
