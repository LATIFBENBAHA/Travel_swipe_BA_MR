package com.travel.swipe.service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.travel.swipe.model.Activite;
import com.travel.swipe.model.Destination;
import com.travel.swipe.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> getDestinationsByActiviteId(Long ActiviteId) {
        return destinationRepository.findByActiviteId(ActiviteId);
    }
    public Destination createDestination(Destination destination) {
        Destination saved = destinationRepository.save(destination);

        Firestore firestore = FirestoreClient.getFirestore();
        firestore.collection("destinations")
                .document(String.valueOf(saved.getId()))
                .set(saved);

        return saved;
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

}
