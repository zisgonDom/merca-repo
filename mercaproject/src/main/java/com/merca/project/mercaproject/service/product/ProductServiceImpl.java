package com.merca.project.mercaproject.service.product;

import com.merca.project.mercaproject.model.Product;
import com.merca.project.mercaproject.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    @Transactional(readOnly = true)
    public Product getProductByEAN(Long EAN) {
        return productRepository.findByEAN(String.valueOf(EAN));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
