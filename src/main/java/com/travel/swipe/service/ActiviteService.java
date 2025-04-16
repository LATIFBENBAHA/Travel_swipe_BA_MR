package com.travel.swipe.service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.travel.swipe.model.Activite;
import com.travel.swipe.model.ActiviteDestination;
import com.travel.swipe.repository.ActiviteRepository;
import com.travel.swipe.repository.ActiviteDestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActiviteService {

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private ActiviteDestinationRepository activiteDestinationRepository;
    public List<Activite> getAllActivites() {
        return activiteRepository.findAll();
    }

//    public Activite createActivite(Activite activite) {
//        Activite saved = activiteRepository.save(activite);
//
//        // Synchroniser avec Firebase
//        Firestore firestore = FirestoreClient.getFirestore();
//        firestore.collection("activites")
//                .document(String.valueOf(saved.getId()))
//                .set(saved);
//
//        return saved;
//    }
    public void lierActiviteEtDestination(Long activiteId, Long destinationId) {
        activiteDestinationRepository.save(new ActiviteDestination(activiteId, destinationId));

        Firestore firestore = FirestoreClient.getFirestore();
        firestore.collection("activite_destination")
                .add(Map.of("activiteId", activiteId, "destinationId", destinationId));
    }


    public Activite getActiviteById(Long id) {
        return activiteRepository.findById(id).orElse(null);
    }
//    public Activite getActiviteByname(String name) {
//        return activiteRepository.findByname(name);
//    }

}
