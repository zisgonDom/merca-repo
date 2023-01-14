package com.merca.project.mercaproject.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String name;
    private String description;
    private Long EAN;
    private Double price;
    private String supplier;
    private String destination;
    private Long productCode;
}
