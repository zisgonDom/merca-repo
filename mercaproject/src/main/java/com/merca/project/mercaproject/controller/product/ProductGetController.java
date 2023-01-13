package com.merca.project.mercaproject.controller.product;

import com.merca.project.mercaproject.model.Product;
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
    public ResponseEntity<List<Product>> list(){
        List<Product> productList = productService.getProducts();
        if(!productList.isEmpty()){
            return new ResponseEntity<>(productList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getProduct/{ean}")
    public ResponseEntity<Product> getProduct(@PathVariable Long ean){
        Product product = productService.getProductByEAN(ean);
        if(product != null){
            return new ResponseEntity<>(productService.getProductByEAN(ean), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
