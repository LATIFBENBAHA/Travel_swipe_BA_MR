package com.travel.swipe.repository;

import com.travel.swipe.model.Activite;
import com.travel.swipe.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByActiviteId(Long activiteId); // utile pour récupérer les destinations par activités likées
}
