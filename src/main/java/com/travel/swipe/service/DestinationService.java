package com.travel.swipe.service;

import com.travel.swipe.model.Destination;
import com.travel.swipe.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id).orElse(null);
    }

    public Destination saveDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public Destination updateDestination(Long id, Destination destination) {
        Optional<Destination> existingDestination = destinationRepository.findById(id);
        if (existingDestination.isPresent()) {
            Destination updatedDestination = existingDestination.get();
            updatedDestination.setNom(destination.getNom());
            updatedDestination.setPays(destination.getPays());
            updatedDestination.setType(destination.getType());
            updatedDestination.setLatitude(destination.getLatitude());
            updatedDestination.setLongitude(destination.getLongitude());
            updatedDestination.setDescription(destination.getDescription());
            return destinationRepository.save(updatedDestination);
        }
        return null;
    }


    public void deleteDestination(Long id) {
        destinationRepository.deleteById(id);
    }

    public List<Destination> getDestinationsByType(String type) {
        return destinationRepository.findByType(type);
    }
}
