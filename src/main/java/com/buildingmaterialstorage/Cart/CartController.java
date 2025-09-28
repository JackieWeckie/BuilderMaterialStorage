package com.buildingmaterialstorage.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@RequestMapping("/your-cart")
@SessionScope
public class CartController {
    @Autowired
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart-page")
    public void createCart(Long userId) {
        cartService.createCart(userId);
    }

    @DeleteMapping("/cart-page-delete-by-id")
    public void removeItemById(Long cartId, CartItem item) {
        cartService.removeFromCart(cartId, item);
    }

    @DeleteMapping("/cart-page-clear")
    public void clearCart(Long userId) {
        cartService.clearCart(userId);
    }

    @PostMapping("/cart-page-add-to-cart")
    public void addSameItem(Long cartId, CartItem item) {
        cartService.addToCart(cartId, item);
    }

    @GetMapping("/cart-page-get-final-price")
    public double getTotalPrice(CartItem cartItem) {
        return cartService.getFinalPrice(cartItem);
    }
}
