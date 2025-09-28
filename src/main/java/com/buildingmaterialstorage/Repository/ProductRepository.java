package com.buildingmaterialstorage.Repository;

import com.buildingmaterialstorage.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    default void addProduct(Long productId, String productName, double productPrice) {
//        if (productName != null && productPrice >= 0.00) {
//            save(new Product()); // could be some troubles there
//        } else {
//            throw new RuntimeException("Введите корректные данные!");
//        }
//    }
//
//
//    default void updateProductData(Long productId, String productName, String productDescription, double productPrice) {
//        if (productId != null && productName != null && productDescription != null && productPrice >= 0.00) {
//            updateProductData(productId, productName, productDescription, productPrice);
//        } else {
//            throw new RuntimeException("Введите корректные данные!");
//        }
//    }
//
//
//    default Long getProductByProductId(Long productId) {
//        if (productId != null) {
//            getProductByProductId(productId);
//        } else {
//            throw new RuntimeException("Введите корректный ID!");
//        }
//        return productId;
//    }
//
//
//    default String getProductByProductName(String productName) {
//        if (productName != null) {
//            getProductByProductName(productName);
//        } else {
//            throw new RuntimeException("Введите корректное название товара!");
//        }
//        return productName;
//    }
//
//
//    default void removeProductByProductId(Long productId) {
//        if (productId != null) {
//            removeProductByProductId(productId);
//        } else {
//            throw new RuntimeException("Введите корректный ID!");
//        }
//    }
}
