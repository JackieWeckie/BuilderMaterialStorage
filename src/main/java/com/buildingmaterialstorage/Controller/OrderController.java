package com.buildingmaterialstorage.Controller;

import com.buildingmaterialstorage.Model.Customer;
import com.buildingmaterialstorage.Model.Order;
import com.buildingmaterialstorage.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/home/products/cart")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create-order")
    public Order createOrder(Long orderId) {
        return orderService.addOrder(orderId);
    }

    @GetMapping("/get-order-by-id")
    public Optional<Order> getOrderById(Long orderId) {
        return orderService.getOrderByOrderId(orderId);
    }

    @PutMapping("/update-order-status")
    public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @PathVariable Order order) {
        Optional<Order> updatedOrder = orderService.updateOrderData(orderId, order);
        return updatedOrder.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/remove-order-by-id")
    public String deleteOrder(Long orderId) {
        orderService.removeOrderByOrderId(orderId);
        return "redirect:/main";
    }
}
