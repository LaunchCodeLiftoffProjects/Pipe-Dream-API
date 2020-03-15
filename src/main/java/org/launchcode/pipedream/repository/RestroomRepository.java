package org.launchcode.pipedream.repository;

import org.launchcode.pipedream.model.Restroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestroomRepository extends JpaRepository<Restroom, Long> {
}

