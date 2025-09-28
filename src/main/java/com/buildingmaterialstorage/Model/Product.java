package com.buildingmaterialstorage.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

//    @NonNull
//    private String productDescription;

    @Column(name = "customer_ID", nullable = false)
    @Size(max = 2_000_000_000)
    private double productPrice;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

//    public @NonNull String getProductDescription() {
//        return productDescription;
//    }
//
//    public void setProductDescription(@NonNull String productDescription) {
//        this.productDescription = productDescription;
//    }

    @Size(max = 2_000_000_000)
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(@Size(max = 2_000_000_000) double productPrice) {
        this.productPrice = productPrice;
    }
}
