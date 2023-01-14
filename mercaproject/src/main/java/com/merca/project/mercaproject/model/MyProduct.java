package com.merca.project.mercaproject.model;

import com.merca.project.mercaproject.exceptions.*;
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


        public MyProduct build() throws DescriptionException, ShortEANException {
            //Validate
            if(this.product == null){
                throw new ProductIsNullException();
            }
            if(this.product.description == null || this.product.description.equals("")){
                throw new DescriptionException("Description field is null or is empty");
            }
            if(this.product.EAN == null) {
                throw new EANException("EAN field is null");
            }

            String EAN = this.product.EAN.toString();

            if(EAN.toCharArray().length < 12) {
                throw new EANException("EAN field does not have 12 digits");
            }
            if(this.product.destination > 9 || this.product.destination == 0){
                throw new EANException("Destination field is not valid");
            }
            return product;
        }


    }

}
