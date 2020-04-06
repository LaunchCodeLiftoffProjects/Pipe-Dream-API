package org.launchcode.pipedream.repository;

import org.launchcode.pipedream.model.Restroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestroomRepository extends JpaRepository<Restroom, Long> {
    boolean existsById(Long id);
    List<Restroom> findByBusinessName(String businessName);
}
