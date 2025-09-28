package com.buildingmaterialstorage.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "customer_ID", nullable = false)
    @JoinColumn(name = "orderId")
    private long customerId;

    @Column(name = "product_ID", nullable = false)
    @JoinColumn(name = "orderId")
    private long productId;

    @Column(name = "product_amount", nullable = false)
    @NonNull
    private Integer productAmount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public @NonNull Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(@NonNull Integer productAmount) {
        this.productAmount = productAmount;
    }
}
