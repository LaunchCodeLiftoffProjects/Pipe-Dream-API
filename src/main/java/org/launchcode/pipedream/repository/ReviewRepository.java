package org.launchcode.pipedream.repository;

import org.launchcode.pipedream.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByRestroomId(Long restroomId);


}