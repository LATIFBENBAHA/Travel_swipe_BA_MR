package com.travel.swipe.repository;

import com.travel.swipe.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long> {
    Optional<Activite> findById(Long ActiviteId);
//    Activite findByname(String name);
}