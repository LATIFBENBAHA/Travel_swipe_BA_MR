package com.travel.swipe.repository;
import com.travel.swipe.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {
}