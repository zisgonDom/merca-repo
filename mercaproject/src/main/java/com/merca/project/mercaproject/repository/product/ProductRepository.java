package com.merca.project.mercaproject.repository.product;

import com.merca.project.mercaproject.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    @Query(value = "SELECT p.id, p.name, p.description, p.ean, p.price FROM PRODUCTS p WHERE LOWER(p.ean) = LOWER(:EAN)", nativeQuery = true)
    ProductEntity findByEAN(@Param("EAN") String EAN);



}
