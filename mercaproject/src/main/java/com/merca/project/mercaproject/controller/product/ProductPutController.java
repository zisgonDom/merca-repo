package com.merca.project.mercaproject.controller.product;

import com.merca.project.mercaproject.exceptions.DescriptionException;
import com.merca.project.mercaproject.exceptions.EANException;
import com.merca.project.mercaproject.exceptions.ProductIsNullException;
import com.merca.project.mercaproject.mapper.ProductCreate;
import com.merca.project.mercaproject.mapper.ProductEdit;
import com.merca.project.mercaproject.mapper.ProductResponse;
import com.merca.project.mercaproject.model.MyProduct;
import com.merca.project.mercaproject.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductPutController {

    @Autowired
    private ProductService productService;

    @PutMapping("/editProduct")
    public ResponseEntity<ProductResponse> editProduct(@RequestBody ProductEdit productEdit) throws DescriptionException {
        ResponseEntity<ProductResponse> responseEntity = null;
        try {
            ProductResponse productResponse = productService.editProduct(productEdit);
            if (productResponse != null) {
                responseEntity = new ResponseEntity<>(productResponse, HttpStatus.CREATED);
            }
        } catch (ProductIsNullException | EANException | DescriptionException e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
