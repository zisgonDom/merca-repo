package com.merca.project.mercaproject.mapper;

import com.merca.project.mercaproject.entity.ProductEntity;
import com.merca.project.mercaproject.exceptions.DescriptionException;
import com.merca.project.mercaproject.model.MyProduct;


public class ProductMapper {
    public static ProductEntity toEntity(MyProduct myProduct) {

        ProductEntity myProductEntity = new ProductEntity();
        myProductEntity.setDescription(myProduct.getDescription());
        myProductEntity.setEAN(myProduct.getEAN());
        myProductEntity.setName(myProduct.getName());
        myProductEntity.setPrice(myProduct.getPrice());
        return myProductEntity;

    }


    public static ProductResponse toProductResponse(ProductEntity productEntity){
        return new ProductResponse(productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getEAN(),
                productEntity.getPrice(),
                takeSupplier(productEntity.getEAN()),
                calculateDestination(takeDestination(productEntity.getEAN())),
                takeProductCode(productEntity.getEAN()));
    }

    public static MyProduct toMyProduct(ProductCreate productCreate) throws DescriptionException {
        return new MyProduct.MyProductBuilder()
                .withDescription(productCreate.getDescription())
                .withEAN(productCreate.getEAN())
                .withName(productCreate.getName())
                .withPrice(productCreate.getPrice())
                .withProductCode(takeProductCode(productCreate.getEAN()))
                .withSupplier(takeSupplier(productCreate.getEAN()))
                .withDestination(takeDestination(productCreate.getEAN()))
                .build();
    }


    public static Long takeSupplier(Long ean) {

        char[] supplierCharacters = ean.toString().toCharArray();
        StringBuilder supplier = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            supplier.append(supplierCharacters[i]);
        }
        return Long.valueOf(supplier.toString());
    }

    public static Long takeProductCode(Long ean) {
        char[] codeCharacters = ean.toString().toCharArray();
        StringBuilder productCode = new StringBuilder();
        for (int i = 7; i < 11; i++) {
            productCode.append(codeCharacters[i]);
        }
        return Long.valueOf(productCode.toString());
    }

    public static int takeDestination(Long ean) {
        char[] destinationCharacters = ean.toString().toCharArray();
        String destinationCode = "";
        destinationCode += destinationCharacters[destinationCharacters.length - 1];

        return Integer.parseInt(destinationCode);
    }

    public static String calculateDestination(int destination){

        if(destination >= 1 && destination < 6){
            return "Mercadona España";
        } else if (destination == 6) {
            return "Mercadona Protugal";
        } else if (destination == 8 ) {
            return "Almacenes";
        } else if (destination == 9) {
            return "Oficinas Mercadona";
        }
        return "Colmenas";
    }
}
