package com.merca.project.mercaproject.repository.product;

import com.merca.project.mercaproject.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT p.id, p.name, p.description, p.ean, p.price FROM PRODUCTS p WHERE LOWER(p.ean) = LOWER(:EAN)", nativeQuery = true)
    Product findByEAN(@Param("EAN") String EAN);

}
