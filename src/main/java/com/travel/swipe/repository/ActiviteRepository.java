package com.travel.swipe.repository;

import com.travel.swipe.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {
    List<Activite> findByDestination_DestinationId(Long destinationId);
}