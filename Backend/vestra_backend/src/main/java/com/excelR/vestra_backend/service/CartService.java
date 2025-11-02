package com.excelR.vestra_backend.service;

import com.excelR.vestra_backend.model.CartItem;
import com.excelR.vestra_backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // ✅ Add item to cart
    public CartItem addToCart(CartItem item) {
        // If already in cart, increase quantity
        if (cartRepository.existsByUserEmailAndProductId(item.getUserEmail(), item.getProductId())) {
            List<CartItem> items = cartRepository.findByUserEmail(item.getUserEmail());
            for (CartItem existing : items) {
                if (existing.getProductId().equals(item.getProductId())) {
                    existing.setQuantity(existing.getQuantity() + item.getQuantity());
                    return cartRepository.save(existing);
                }
            }
        }
        return cartRepository.save(item);
    }

    // ✅ Get cart items for user
    public List<CartItem> getCartByUser(String userEmail) {
        return cartRepository.findByUserEmail(userEmail);
    }

    // ✅ Remove item from cart
    public void removeFromCart(String userEmail, String productId) {
        cartRepository.deleteByUserEmailAndProductId(userEmail, productId);
    }

    // ✅ Clear entire cart for a user (optional)
    public void clearCart(String userEmail) {
        List<CartItem> items = cartRepository.findByUserEmail(userEmail);
        cartRepository.deleteAll(items);
    }
}

