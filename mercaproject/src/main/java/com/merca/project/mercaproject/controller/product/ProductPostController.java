package com.merca.project.mercaproject.controller.product;

import com.merca.project.mercaproject.exceptions.DescriptionException;
import com.merca.project.mercaproject.exceptions.EANException;
import com.merca.project.mercaproject.exceptions.ProductExistsException;
import com.merca.project.mercaproject.exceptions.ProductIsNullException;
import com.merca.project.mercaproject.mapper.ProductCreate;
import com.merca.project.mercaproject.mapper.ProductMapper;
import com.merca.project.mercaproject.mapper.ProductResponse;
import com.merca.project.mercaproject.model.MyProduct;
import com.merca.project.mercaproject.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductPostController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductCreate productCreate){
        ResponseEntity<ProductResponse> responseEntity = null;
       try {
           ProductResponse productResponse = productService.createProduct(productCreate);

           if (productResponse != null) {
               responseEntity = new ResponseEntity<>(productResponse, HttpStatus.CREATED);
           }
       }catch (DescriptionException | EANException | ProductIsNullException | ProductExistsException exception){
           log.info(exception.getMessage());
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
       return responseEntity;
    }

}
