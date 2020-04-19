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
@RequestMapping("/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    Review add(@RequestBody Review review){
        return reviewService.add(review);
    }
}
