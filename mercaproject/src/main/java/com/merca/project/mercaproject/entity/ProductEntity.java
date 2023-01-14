package com.merca.project.mercaproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;
    private Long EAN;
    private Double price;

    public ProductEntity(String name, String description, Long EAN, Double price) {
        this.name = name;
        this.description = description;
        this.EAN = EAN;
        this.price = price;
    }

    public ProductEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductEntity productEntity = (ProductEntity) o;
        return id != null && Objects.equals(id, productEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
