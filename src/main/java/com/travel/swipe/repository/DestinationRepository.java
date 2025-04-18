package com.travel.swipe.repository;

import com.travel.swipe.model.Activite;
import com.travel.swipe.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    @Query("SELECT d FROM Destination d JOIN d.activites a WHERE a.id = :activiteId")
    List<Destination> findByActiviteId(@Param("activiteId") Long activiteId); // utile pour récupérer les destinations par activités likées
}
