package com.merca.project.mercaproject.controller.product;

import com.merca.project.mercaproject.mapper.ProductResponse;
import com.merca.project.mercaproject.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDeteleController {

    @Autowired
    private ProductService productService;

    @DeleteMapping("/deleteProduct/{EAN}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long EAN){
        ProductResponse productResponse = productService.deleteProduct(EAN);
        if(productResponse != null){
            return new ResponseEntity<>("Product with EAN: " + productResponse.getEAN() + " removed", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
