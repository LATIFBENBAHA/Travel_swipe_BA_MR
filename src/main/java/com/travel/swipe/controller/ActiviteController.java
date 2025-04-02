package com.travel.swipe.controller;

import com.travel.swipe.model.Activite;
import com.travel.swipe.service.ActiviteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activites")
public class ActiviteController {

    private final ActiviteService activiteService;

    public ActiviteController(ActiviteService activiteService) {
        this.activiteService = activiteService;
    }


    @GetMapping("/destination/{destinationId}")
    public List<Activite> getActivitesByDestination(@PathVariable Long destinationId) {
        return activiteService.getActivitesByDestinationId(destinationId);
    }
    @GetMapping
    public List<Activite> getAllActivites() {
        return activiteService.getAllActivites();
    }

    @GetMapping("/{id}")
    public Activite getActiviteById(@PathVariable Long id) {
        return activiteService.getActiviteById(id);
    }
    @PostMapping
    public Activite createActivite(@RequestBody Activite activite) {
        return activiteService.saveActivite(activite);
    }

    @PutMapping("/{id}")
    public Activite updateActivite(@PathVariable Long id, @RequestBody Activite activite) {
        return activiteService.updateActivite(id, activite);
    }

    @DeleteMapping("/{id}")
    public void deleteActivite(@PathVariable Long id) {
        activiteService.deleteActivite(id);
    }
}
