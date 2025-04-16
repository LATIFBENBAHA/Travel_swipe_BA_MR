package com.travel.swipe.controller;

import com.travel.swipe.model.Activite;
import com.travel.swipe.model.Destination;
import com.travel.swipe.repository.ActiviteRepository;
import com.travel.swipe.service.ActiviteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/activites")
public class ActiviteController {
    @Autowired
    private ActiviteService activiteService;

    @Autowired
    private ActiviteRepository activiteRepository;

    @GetMapping
    public List<Activite> getAllActivites() {
        return activiteService.getAllActivites();
    }

    @PostMapping("/activite-destination")
    public String lier(@RequestBody Map<String, Long> body) {
        Long activiteId = body.get("activiteId");
        Long destinationId = body.get("destinationId");

        activiteService.lierActiviteEtDestination(activiteId, destinationId);
        return "Lien ajouté avec succès !";
    }
    // Méthode pour obtenir une activité par ID
    @GetMapping("/{id}")
    public ResponseEntity<Activite> getActivite(@PathVariable Long id) {
        Activite activite = activiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activité non trouvée"));
        return ResponseEntity.ok(activite);
    }

}
