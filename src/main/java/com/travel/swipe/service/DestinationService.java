package com.travel.swipe.service;

import com.travel.swipe.model.Destination;
import com.travel.swipe.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getDestinationsByType(String type) {
        return destinationRepository.findByType(type);
    }
}
