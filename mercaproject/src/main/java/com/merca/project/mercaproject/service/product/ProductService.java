package com.merca.project.mercaproject.service.product;

import com.merca.project.mercaproject.model.Product;

import java.util.List;

public interface ProductService {

    public Product getProductByEAN(Long EAN);
    List<Product> getProducts();
    Product findById(Long id);


}
