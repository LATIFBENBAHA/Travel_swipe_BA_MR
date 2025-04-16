package com.travel.swipe.service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.travel.swipe.model.*;
import com.travel.swipe.model.User;
import com.travel.swipe.repository.DestinationRepository;
import com.travel.swipe.repository.FavorisDestinationRepository;
import com.travel.swipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FavorisDestinationService {
    @Autowired
    private FavorisDestinationRepository favorisDestinationRepository;
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private UserRepository userRepository;

    public void likerDestination (Long userId, Long DestinationId){
        User user = userRepository.findById(userId).orElseThrow();
        FavorisDestination favorisDestination=favorisDestinationRepository.findByUser(user);
        Destination destination = destinationRepository.findById(DestinationId).orElse(null);
        if (!favorisDestination.getDestinations().contains(destination)){
            favorisDestination.add(destination);
            favorisDestinationRepository.save(favorisDestination);
            // Enregistrement dans Firebase
            Firestore firestore = FirestoreClient.getFirestore();
            firestore.collection("favorisactivites")
                    .add(Map.of("user", userId, "destination", favorisDestination.getDestinations()));
        }

    }
    public List<Destination> getDestinationsLikees(User user) {
        return favorisDestinationRepository.findByUser(user).getDestinations();
    }

    public List<FavorisDestination> getAllFavorisDestinations(){return favorisDestinationRepository.findAll();}
}
