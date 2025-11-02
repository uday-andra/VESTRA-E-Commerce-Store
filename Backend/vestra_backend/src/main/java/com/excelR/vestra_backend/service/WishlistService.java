package com.excelR.vestra_backend.service;

import com.excelR.vestra_backend.model.WishlistItem;
import com.excelR.vestra_backend.repository.WishlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    // ✅ Get all wishlist items for a user
    public List<WishlistItem> getWishlist(String userEmail) {
        return wishlistRepository.findByUserEmail(userEmail);
    }

    // ✅ Add item only if not already exists
    public WishlistItem addToWishlist(WishlistItem item) {
        boolean exists = wishlistRepository.existsByUserEmailAndProductId(
                item.getUserEmail(), item.getProductId());
        if (exists) {
            // Item already in wishlist → return same without saving again
            return item;
        }
        return wishlistRepository.save(item);
    }

    // ✅ Proper remove with existence check and exception handling
    @Transactional
    public void removeFromWishlist(String userEmail, String productId) {
        boolean exists = wishlistRepository.existsByUserEmailAndProductId(userEmail, productId);
        if (!exists) {
            throw new IllegalArgumentException("Item not found in wishlist");
        }
        wishlistRepository.deleteByUserEmailAndProductId(userEmail, productId);
    }
}
