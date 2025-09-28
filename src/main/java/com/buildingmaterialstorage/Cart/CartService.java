package com.buildingmaterialstorage.Cart;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    public Cart createCart(Long userId) {
        return cartRepository.findAll().stream()
                .filter(c -> userId.equals(c.getCustomerId()))
                .findFirst()
                .orElseGet(() -> {
                    Cart c = new Cart();
                    c.setCustomerId(userId);
                    return cartRepository.save(c);
                });
    }

    @Transactional
    public void addToCart(Long cartId, CartItem item) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        cart.addItem(item);
        cartRepository.save(cart);
    }

    @Transactional
    public void removeFromCart(Long cartId, CartItem item) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        cart.removeItem(item);
        cartRepository.delete(cart);
    }

    @Transactional
    public void clearCart(Long userId) {
        Cart cart = cartRepository.findById(userId).orElseThrow();
        cart.getItems().clear();
    }

    public double getFinalPrice(CartItem cartItem) {
        return cartItem.getFinalPrice() * cartItem.getProductCount();
    }
}
