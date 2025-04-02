package com.travel.swipe.repository;
import com.travel.swipe.model.Recherche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechercheRepository extends JpaRepository<Recherche, Long> {
    List<Recherche> findByUser_UserId(Long userId);
}