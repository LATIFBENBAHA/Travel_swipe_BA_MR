package com.travel.swipe.repository;
import com.travel.swipe.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteRepository extends JpaRepository<Carte, Long> {
    
}