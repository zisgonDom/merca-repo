package com.merca.project.mercaproject.controller.product;

import com.merca.project.mercaproject.exceptions.DescriptionException;
import com.merca.project.mercaproject.exceptions.EANException;
import com.merca.project.mercaproject.exceptions.ProductIsNullException;
import com.merca.project.mercaproject.mapper.ProductCreate;
import com.merca.project.mercaproject.mapper.ProductMapper;
import com.merca.project.mercaproject.mapper.ProductResponse;
import com.merca.project.mercaproject.model.MyProduct;
import com.merca.project.mercaproject.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPostController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductCreate productCreate) throws DescriptionException, EANException, ProductIsNullException {
        ProductResponse productResponse = productService.createProduct(productCreate);
        if(productResponse != null){
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
