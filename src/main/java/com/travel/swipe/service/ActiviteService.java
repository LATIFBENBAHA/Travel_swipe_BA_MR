package com.travel.swipe.service;

import com.travel.swipe.model.Activite;
import com.travel.swipe.repository.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActiviteService {
    private  ActiviteRepository activiteRepository;

    @Autowired
    public ActiviteService(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    public void deleteActivite(Long id) {
        activiteRepository.deleteById(id);
    }

    public Activite updateActivite(Long id, Activite activite) {
        Optional<Activite> existingActivite = activiteRepository.findById(id);
        if (existingActivite.isPresent()) {
            Activite updatedActivite = existingActivite.get();
            updatedActivite.setNom(activite.getNom());
            updatedActivite.setDescription(activite.getDescription());
            updatedActivite.setDestination(activite.getDestination());
            return activiteRepository.save(updatedActivite);
        }
        return null;
    }

    public Activite saveActivite(Activite activite) {
        return activiteRepository.save(activite);
    }

    public List<Activite> getActivitesByDestinationId(Long destinationId) {
        return activiteRepository.findByDestination_DestinationId(destinationId);
    }

    public Activite getActiviteById(Long id) {
        return activiteRepository.findById(id).orElse(null);
    }

    public List<Activite> getAllActivites() {
        return activiteRepository.findAll();
    }
}
