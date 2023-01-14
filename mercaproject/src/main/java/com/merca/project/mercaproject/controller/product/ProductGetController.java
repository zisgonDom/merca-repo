package com.merca.project.mercaproject.controller.product;

import com.merca.project.mercaproject.exceptions.EANException;
import com.merca.project.mercaproject.exceptions.ProductIsNullException;
import com.merca.project.mercaproject.mapper.ProductResponse;
import com.merca.project.mercaproject.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductGetController {

    @Autowired
    private ProductService productService;

    @GetMapping("/listProducts")
    public ResponseEntity<List<ProductResponse>> list(){
        ResponseEntity<List<ProductResponse>> responseEntity = null;
        try {
            List<ProductResponse> productResponseList = productService.getProducts();

            if (!productResponseList.isEmpty()) {
                responseEntity = new ResponseEntity<>(productResponseList, HttpStatus.OK);
            }
        } catch (ProductIsNullException e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        return responseEntity;
    }

    @GetMapping("/getProduct/{ean}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long ean){
        ResponseEntity<ProductResponse> responseEntity = null;
        try {
            ProductResponse productResponse = productService.getProductByEAN(ean);
            if(productResponse != null){
                responseEntity =  new ResponseEntity<>(productResponse, HttpStatus.OK);
            }
        }catch (EANException | ProductIsNullException e){
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }



}
