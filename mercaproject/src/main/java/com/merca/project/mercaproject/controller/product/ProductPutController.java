package com.merca.project.mercaproject.controller.product;

import com.merca.project.mercaproject.exceptions.DescriptionException;
import com.merca.project.mercaproject.mapper.ProductCreate;
import com.merca.project.mercaproject.mapper.ProductEdit;
import com.merca.project.mercaproject.mapper.ProductResponse;
import com.merca.project.mercaproject.model.MyProduct;
import com.merca.project.mercaproject.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductPutController {

    @Autowired
    private ProductService productService;

    @PutMapping("/editProduct")
    public ResponseEntity<ProductResponse> editProduct(@RequestBody ProductEdit productEdit) throws DescriptionException {
        ProductResponse productResponse = productService.editProduct(productEdit);
        if(productResponse != null){
            return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
