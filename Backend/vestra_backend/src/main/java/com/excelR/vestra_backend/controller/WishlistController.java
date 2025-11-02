package com.excelR.vestra_backend.controller;

import com.excelR.vestra_backend.model.WishlistItem;
import com.excelR.vestra_backend.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // ✅ React frontend
@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	// ✅ Get all wishlist items for a user
	@GetMapping("/{userEmail}")
	public ResponseEntity<List<WishlistItem>> getWishlist(@PathVariable String userEmail) {
		return ResponseEntity.ok(wishlistService.getWishlist(userEmail));
	}

	// ✅ Add an item to the wishlist
	@PostMapping("/add")
	public ResponseEntity<WishlistItem> addToWishlist(@RequestBody WishlistItem item) {
		WishlistItem savedItem = wishlistService.addToWishlist(item);
		return ResponseEntity.ok(savedItem);
	}

	// ✅ Remove a specific item (DELETE method now properly supported)
//	@DeleteMapping("/remove/{userEmail}/{productId}")
//	public ResponseEntity<String> removeFromWishlist(@PathVariable String userEmail, @PathVariable String productId) {
//
//		boolean removed = wishlistService.removeFromWishlist(userEmail, productId);
//
//		if (removed) {
//			return ResponseEntity.ok("Item removed from wishlist");
//		} else {
//			return ResponseEntity.badRequest().body("Item not found in wishlist");
//		}
//	}
	
	
//	DELETE /api/wishlist/{userEmail}/{productId}
	@DeleteMapping("/{userEmail}/{productId}")
	public ResponseEntity<String> removeFromWishlist(@PathVariable String userEmail,
	                                                 @PathVariable String productId) {
	    try {
	        wishlistService.removeFromWishlist(userEmail, productId);
	        return ResponseEntity.ok("Item removed from wishlist");
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}

}
