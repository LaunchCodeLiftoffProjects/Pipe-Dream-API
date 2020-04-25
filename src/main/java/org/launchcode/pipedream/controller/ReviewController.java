package org.launchcode.pipedream.controller;

import org.launchcode.pipedream.model.Review;
import org.launchcode.pipedream.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins={"http://localhost:3000"})
@RestController
@RequestMapping("/reviews/{restroomId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Review add(@RequestBody Review review) {
        return reviewService.add(review);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("{id}")
    ResponseEntity<Review> get(@PathVariable Long id) {
        Optional<Review> review = reviewService.get(id);
        if (review.isPresent()) {
            return ResponseEntity.ok().body(review.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/restrooms/{restroomId}")
    List<Review> getByRestroom(@PathVariable Long restroomId) {
        return reviewService.getByRestroom(restroomId);
    }

    @PutMapping("/{id}")
    ResponseEntity<Review> update(@RequestBody Review newReview) {
        Optional<Review> review = reviewService.update(newReview);
        if (review.isPresent()) {
            return ResponseEntity.ok().body(review.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        if (reviewService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}