package com.travel.swipe.repository;

import com.travel.swipe.model.FavorisDestination;
import com.travel.swipe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavorisDestinationRepository extends JpaRepository<FavorisDestination, Long> {
    FavorisDestination findByUser(User user);
}
