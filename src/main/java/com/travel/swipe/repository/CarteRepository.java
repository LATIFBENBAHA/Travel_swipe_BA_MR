package com.travel.swipe.repository;
import com.travel.swipe.model.Activite;
import com.travel.swipe.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarteRepository extends JpaRepository<Carte, Long> {
    List<Carte> findByDestination_DestinationId(Long destinationId);

}