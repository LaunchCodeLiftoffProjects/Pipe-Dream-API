package org.launchcode.pipedream.service;

import org.launchcode.pipedream.model.Review;
import org.launchcode.pipedream.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Optional<Review> get(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getByRestroom(Long id) {
        return reviewRepository.findByRestroomId(id);
    }

    public Review add(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> update(Review review) {
        if(reviewRepository.existsById(review.getId())){
            reviewRepository.save(review);
            return Optional.of(review);
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }
}