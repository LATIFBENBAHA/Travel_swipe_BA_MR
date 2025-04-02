package com.travel.swipe.controller;

import com.travel.swipe.model.Destination;
import com.travel.swipe.service.DestinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id);
    }

    @GetMapping("/type/{type}")
    public List<Destination> getDestinationsByType(@PathVariable String type) {
        return destinationService.getDestinationsByType(type);
    }

    @PostMapping
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationService.saveDestination(destination);
    }

    @PutMapping("/{id}")
    public Destination updateDestination(@PathVariable Long id, @RequestBody Destination destination) {
        return destinationService.updateDestination(id, destination);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
    }
}
