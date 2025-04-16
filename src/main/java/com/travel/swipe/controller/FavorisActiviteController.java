package com.travel.swipe.controller;

import com.google.firebase.auth.FirebaseToken;
import com.travel.swipe.model.*;
import com.travel.swipe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/favorisactivites")
public class FavorisActiviteController {


    @Autowired
    private FavorisActiviteService favorisActiviteService;
    @Autowired
    private DestinationService destinationService;
    @GetMapping
    public List<FavorisActivite> getAllFavorisActivites() {
        return favorisActiviteService.getAllFavorisActivites();
    }
    @PostMapping("/like")
    public ResponseEntity<?> likeActivite(@RequestBody Map<String, Long> data) {
        Long userId = data.get("userId");
        Long activiteId = data.get("activiteId");
        favorisActiviteService.likerActivite(userId,activiteId);
//        // Ajoute les destinations liées à cette activité dans le buffer
//        List<Destination> destinationsLiees = destinationService.getDestinationsByActiviteId(activiteId);
//        for (Destination d : destinationsLiees) {
//            destinationBufferService.addDestination(d);
//        }
        return ResponseEntity.ok().build();
    }
    @PostMapping("/dislike")
    public ResponseEntity<?> dislikeActivite(@RequestBody Map<String, Long> data) {
        Long userId = data.get("userId");
        Long activiteId = data.get("activiteId");

        // Supprimer l'activité des favoris si elle y est
        favorisActiviteService.unlikerActivite(userId, activiteId);

        return ResponseEntity.ok().build();
    }



    @GetMapping("/liked-activities/{userId}")
    public List<Activite> getLikedActivities(@PathVariable Long userId) {
//        User user = new User();
//        user.setId(userId);
        return favorisActiviteService.getActivitesLikees(userId);
    }
}
