package com.excelR.vestra_backend.controller;

import com.excelR.vestra_backend.model.CartItem;
import com.excelR.vestra_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // ✅ Add item to cart
    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartService.addToCart(item);
    }

    // ✅ Get all cart items for a user
    @GetMapping("/{userEmail}")
    public List<CartItem> getCart(@PathVariable String userEmail) {
        return cartService.getCartByUser(userEmail);
    }

    // ✅ Remove single item from cart
    @DeleteMapping("/remove/{userEmail}/{productId}")
    public void removeFromCart(@PathVariable String userEmail, @PathVariable String productId) {
        cartService.removeFromCart(userEmail, productId);
    }

    // ✅ Clear all items in user's cart
    @DeleteMapping("/clear/{userEmail}")
    public void clearCart(@PathVariable String userEmail) {
        cartService.clearCart(userEmail);
    }
}

