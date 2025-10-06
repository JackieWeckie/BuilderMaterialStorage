package com.buildingmaterialstorage.Service;

import com.buildingmaterialstorage.Cart.Cart;
import com.buildingmaterialstorage.Categories.OrderCategory;
import com.buildingmaterialstorage.Enum.OrderEnum;
import com.buildingmaterialstorage.Model.Order;
import com.buildingmaterialstorage.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor(force = true)
public class OrderService {
    static OrderEnum orderEnum;
    @Autowired
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order addOrder(Long orderId) {
        return orderRepository.findAll().stream().
                filter(o -> orderId.equals(o.getCustomerId()))
                .findFirst()
                .orElseGet(() -> {
                    Order o = new Order();
                    o.setCustomerId(orderId);
                    return orderRepository.save(o);
                });
    }

    public Optional<Order> getOrderByOrderId(Long orderId) {
        return Optional.of(orderRepository.findById(orderId).orElseThrow());
    }

    @Transactional
    public Optional<Order> updateOrderData(Long orderId, Order updatedOrder) {
        return orderRepository.findById(orderId).map(existingOrder -> {
            existingOrder.setOrderId(updatedOrder.getOrderId());
            existingOrder.setCustomerId(updatedOrder.getCustomerId());
            existingOrder.setProductId(updatedOrder.getProductId());
            existingOrder.setProductAmount(updatedOrder.getProductAmount());
            return orderRepository.save(existingOrder);
        });
    }

    public void setOrderCategory(Long orderId, OrderCategory orderCategoryId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setOrderCategory(orderCategoryId);

        orderRepository.save(order);
    }

    @Transactional
    public void removeOrderByOrderId(Long orderId) {
        if (orderRepository != null && orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new RuntimeException("Заказ с таким ID не найден!");
        }
    }
}
