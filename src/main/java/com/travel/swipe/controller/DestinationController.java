package com.travel.swipe.controller;

import com.travel.swipe.model.Activite;
import com.travel.swipe.model.Destination;
import com.travel.swipe.model.FavorisActivite;

import com.travel.swipe.service.DestinationService;
import com.travel.swipe.service.FavorisActiviteService;
import com.travel.swipe.service.FavorisDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
    @Autowired
    private DestinationService destinationService;
    @Autowired
    private FavorisActiviteService favorisActiviteService;

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }
    @PostMapping("/by-activites")
    public List<Destination> getDestinations(@RequestBody Long activiteId) {
        return destinationService.getDestinationsByActiviteId(activiteId);
    }
    // Endpoint pour obtenir la liste des destinations à la fin
    @GetMapping("/finales")
    public ResponseEntity<List<Destination>> getDestinationsFinales(@RequestParam Long userId) {
        List<Activite> activitesLikees = favorisActiviteService.getActivitesLikees(userId);
        Set<Destination> destinations = new HashSet<>();

        for (Activite activite : activitesLikees) {
            List<Destination> liees = destinationService.getDestinationsByActiviteId(activite.getId());
            destinations.addAll(liees); // HashSet élimine les doublons automatiquement
        }

        if (destinations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(new ArrayList<>(destinations));
    }




}
//    // Réinitialiser les destinations (pour un nouveau cycle)
//    @PostMapping("/reset")
//    public ResponseEntity<Void> resetDestinations() {
//        destinationBufferService.reset();
//        return ResponseEntity.ok().build();
//    }