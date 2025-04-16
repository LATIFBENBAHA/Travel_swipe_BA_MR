package com.travel.swipe.controller;

import com.travel.swipe.model.*;
import com.travel.swipe.repository.FavorisDestinationRepository;
import com.travel.swipe.service.FavorisDestinationService;
import com.travel.swipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/favorisdestinations")
public class FavorisDestinationController {
    @Autowired
    private FavorisDestinationService favorisDestinationService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<FavorisDestination> getAllFavorisDestination(){return favorisDestinationService.getAllFavorisDestinations();}
    @PostMapping("/like")
    public ResponseEntity<?> likerDestination(@RequestBody Map<String, Long> data) {
        Long userId = data.get("userId");
        Long destinationId = data.get("destinationId");
        favorisDestinationService.likerDestination(userId,destinationId);
        return ResponseEntity.ok("Liked!");
    }

    @GetMapping("/liked-destinations/{userId}")
    public List<Destination> getLikedActivities(@PathVariable Long userId) {
//        User user = new User();
//        user.setId(userId);
        User user =userService.getUserByUserId(userId);
        return favorisDestinationService.getDestinationsLikees(user);
    }

}
