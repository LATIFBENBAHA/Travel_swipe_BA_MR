package com.travel.swipe.repository;

import com.travel.swipe.model.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavorisRepository extends JpaRepository<Favoris, Long> {
}
