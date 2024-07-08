package com.example.review.controller;

import com.example.review.model.Review;
import com.example.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/review")
    public List<Review> getAllReviews(@RequestParam(required = false) String sort,
                                      @RequestParam(required = false) String idSeller,
                                      @RequestParam(required = false) String idClient) {
        return reviewService.getAllReviews();
    }

    @PostMapping("/review")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review review) {
        Review updatedReview = reviewService.updateReview(id, review);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/review-stats/{idSeller}")
    public ResponseEntity<?> getReviewStats(@PathVariable String idSeller) {
        return ResponseEntity.ok().build();
    }
}
