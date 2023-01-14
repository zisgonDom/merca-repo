package com.merca.project.mercaproject.service.product;

import com.merca.project.mercaproject.entity.ProductEntity;
import com.merca.project.mercaproject.mapper.ProductResponse;

import java.util.List;

public interface ProductService {

    public ProductResponse getProductByEAN(Long EAN);
    List<ProductResponse> getProducts();
    ProductEntity findById(Long id);




}
