package com.merca.project.mercaproject.service.product;

import com.merca.project.mercaproject.entity.ProductEntity;
import com.merca.project.mercaproject.exceptions.DescriptionException;
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
        return ProductMapper.toProductResponse(productEntity);
    }
    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getProducts() {
        List<ProductEntity> productEntityList = (List<ProductEntity>) productRepository.findAll();
        List<ProductResponse> productResponseList = new ArrayList<>();
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
    public ProductResponse createProduct(ProductCreate productCreate) throws DescriptionException {

        MyProduct myProduct = ProductMapper.toMyProduct(productCreate);
        ProductEntity productEntity = ProductMapper.toEntity(myProduct);
        productRepository.save(productEntity);
        return ProductMapper.toProductResponse(productRepository.findById(productEntity.getId()).orElse(null));
    }

    @Override
    public ProductResponse editProduct(ProductEdit productEdit) throws DescriptionException {
        ProductEntity productEntity = productRepository.findByEAN(productEdit.getEAN().toString());
        ProductResponse productResponse = new ProductResponse();
        if(productEntity != null){
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
        if(productEntity != null){
            productResponse = ProductMapper.toProductResponse(productEntity);
            productRepository.delete(productEntity);
            if(productRepository.findByEAN(productResponse.getEAN().toString()) != null){
                productResponse = null;
            }
        }
        return productResponse;
    }


}
