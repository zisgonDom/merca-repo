package com.merca.project.mercaproject.controller.product;

import com.merca.project.mercaproject.mapper.ProductResponse;
import com.merca.project.mercaproject.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductGetController {

    @Autowired
    private ProductService productService;

    @GetMapping("/listProducts")
    public ResponseEntity<List<ProductResponse>> list(){
        List<ProductResponse> productResponseList = productService.getProducts();
        if(!productResponseList.isEmpty()){
            return new ResponseEntity<>(productResponseList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getProduct/{ean}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long ean){
        ProductResponse productResponse = productService.getProductByEAN(ean);
        if(productResponse != null){
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
