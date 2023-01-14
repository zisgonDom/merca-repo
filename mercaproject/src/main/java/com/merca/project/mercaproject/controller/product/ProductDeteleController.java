package com.merca.project.mercaproject.controller.product;

import com.merca.project.mercaproject.exceptions.ProductIsNullException;
import com.merca.project.mercaproject.mapper.ProductResponse;
import com.merca.project.mercaproject.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductDeteleController {

    @Autowired
    private ProductService productService;

    @DeleteMapping("/deleteProduct/{EAN}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long EAN){
        ResponseEntity<String> responseEntity = null;
        try {
            ProductResponse productResponse = productService.deleteProduct(EAN);
            if (productResponse != null) {
                responseEntity = new ResponseEntity<>("Product with EAN: " + productResponse.getEAN() + " removed", HttpStatus.OK);
            }
        }catch (ProductIsNullException e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
