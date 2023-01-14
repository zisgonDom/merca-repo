package com.merca.project.mercaproject.model;

import com.merca.project.mercaproject.exceptions.EmptyDescriptionException;
import com.merca.project.mercaproject.exceptions.ProductEANException;
import com.merca.project.mercaproject.exceptions.ProductIsNullException;
import com.merca.project.mercaproject.exceptions.ShortEANException;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyProduct {
    private Long id;
    private Long EAN;
    private String name;
    private String description;
    private Long supplier;
    private Long productCode;
    private int destination;
    private Double price;

    public MyProduct() {

    }


    public static class MyProductBuilder {
        private MyProduct product;

        public MyProductBuilder() {
            product = new MyProduct();
        }


        public MyProductBuilder(MyProduct product) {
            this.product = product;
        }


        public MyProductBuilder withName(String name) {
            product.name = name;
            return this;
        }

        public MyProductBuilder withId(Long id) {
            product.id = id;
            return this;
        }

        public MyProductBuilder withDescription(String description) {
            product.description = description;
            return this;
        }

        public MyProductBuilder withPrice(Double price) {
            product.price = price;
            return this;
        }

        public MyProductBuilder withEAN(Long EAN) {
            product.EAN = EAN;
            return this;
        }


        public MyProduct build() throws EmptyDescriptionException, ProductEANException, ShortEANException {
            //Validate
            if(this.product == null){
                throw new ProductIsNullException();
            }
            if(this.product.description == null || this.product.description.equals("")){
                throw new EmptyDescriptionException();
            }
            if(this.product.EAN == null) {
                throw new ProductEANException();
            }

            String EAN = this.product.EAN.toString();

            if(EAN.toCharArray().length < 12) {
                throw new ShortEANException();
            }
            if(this.product.destination > 9 || this.product.destination == 0){

            }
            return product;
        }


    }

}
