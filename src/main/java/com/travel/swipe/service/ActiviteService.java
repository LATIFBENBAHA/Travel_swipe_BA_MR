package com.travel.swipe.service;

import com.travel.swipe.model.Activite;
import com.travel.swipe.repository.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActiviteService {
    private  ActiviteRepository activiteRepository;

    @Autowired
    public ActiviteService(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    public List<Activite> getActivitesByDestination(Long destinationId) {
        return activiteRepository.findByDestination_DestinationId(destinationId);
    }
}
