package com.merca.project.mercaproject.service.product;

import com.merca.project.mercaproject.entity.ProductEntity;
import com.merca.project.mercaproject.exceptions.DescriptionException;
import com.merca.project.mercaproject.mapper.ProductCreate;
import com.merca.project.mercaproject.mapper.ProductEdit;
import com.merca.project.mercaproject.mapper.ProductResponse;

import java.util.List;

public interface ProductService {

    public ProductResponse getProductByEAN(Long EAN);
    List<ProductResponse> getProducts();
    ProductEntity findById(Long id);
    ProductResponse createProduct(ProductCreate productCreate) throws DescriptionException;

    ProductResponse editProduct(ProductEdit productEdit) throws DescriptionException;

    ProductResponse deleteProduct(Long EAN);

}
