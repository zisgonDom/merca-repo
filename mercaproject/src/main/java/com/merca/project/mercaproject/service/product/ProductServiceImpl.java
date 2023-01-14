package com.merca.project.mercaproject.service.product;

import com.merca.project.mercaproject.entity.ProductEntity;
import com.merca.project.mercaproject.exceptions.DescriptionException;
import com.merca.project.mercaproject.exceptions.ProductExistsException;
import com.merca.project.mercaproject.exceptions.ProductIsNullException;
import com.merca.project.mercaproject.mapper.ProductCreate;
import com.merca.project.mercaproject.mapper.ProductEdit;
import com.merca.project.mercaproject.mapper.ProductMapper;
import com.merca.project.mercaproject.mapper.ProductResponse;
import com.merca.project.mercaproject.model.MyProduct;
import com.merca.project.mercaproject.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    @Transactional(readOnly = true)
    public ProductResponse getProductByEAN(Long EAN) {
        ProductEntity productEntity = productRepository.findByEAN(String.valueOf(EAN));
        if(productEntity == null){
            throw new ProductIsNullException("There are no product with EAN: " + EAN);
        }
        return ProductMapper.toProductResponse(productEntity);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getProducts() {
        List<ProductEntity> productEntityList = (List<ProductEntity>) productRepository.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();
        if(productEntityList.isEmpty()){
            throw new ProductIsNullException("No products in the database");
        }
        for(ProductEntity productEntity : productEntityList){
            productResponseList.add(ProductMapper.toProductResponse(productEntity));
        }
        return productResponseList;
    }
    @Override
    @Transactional(readOnly = true)
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ProductResponse createProduct(ProductCreate productCreate) {

        MyProduct myProduct = ProductMapper.toMyProduct(productCreate);
        ProductEntity productEntity = ProductMapper.toEntity(myProduct);
        if(productRepository.findByEAN(productEntity.getEAN().toString()) != null){
            throw new ProductExistsException("A product with EAN: " + productEntity.getEAN() + " alredy exists");
        }
        productRepository.save(productEntity);
        return ProductMapper.toProductResponse(productRepository.findById(productEntity.getId()).orElse(null));
    }

    @Override
    public ProductResponse editProduct(ProductEdit productEdit) throws DescriptionException {
        MyProduct myProduct = ProductMapper.toMyProduct(productEdit);
        ProductEntity productEntity = productRepository.findByEAN(myProduct.getEAN().toString());
        ProductResponse productResponse = new ProductResponse();
        if(productEntity == null) {
            throw new ProductIsNullException("There is no products with EAN: " + productEdit.getEAN());
        }else {
            productEntity.setDescription(productEdit.getDescription());
            productEntity.setName(productEdit.getName());
            productEntity.setPrice(productEdit.getPrice());
            productEntity.setEAN(productEdit.getEAN());
            productResponse = ProductMapper.toProductResponse(productEntity);
        }
        return productResponse;
    }

    @Override
    @Transactional
    public ProductResponse deleteProduct(Long EAN) {
        ProductEntity productEntity = productRepository.findByEAN(EAN.toString());
        ProductResponse productResponse = null;
        if(productEntity == null) {
            throw new ProductIsNullException("There is no products with EAN: " + EAN);
        }else {
            productResponse = ProductMapper.toProductResponse(productEntity);
            productRepository.delete(productEntity);
            if(productRepository.findByEAN(productResponse.getEAN().toString()) != null){
                productResponse = null;
            }
        }
        return productResponse;
    }


}
