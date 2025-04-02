package com.travel.swipe.controller;

import com.travel.swipe.model.Recherche;
import com.travel.swipe.service.RechercheService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recherches")
public class RechercheController {

    private final RechercheService rechercheService;

    public RechercheController(RechercheService rechercheService) {
        this.rechercheService = rechercheService;
    }

    @GetMapping("/user/{userId}")
    public List<Recherche> getRecherchesByUser(@PathVariable Long userId) {
        return rechercheService.getRecherchesByUserId(userId);
    }

    @PostMapping
    public Recherche createRecherche(@RequestBody Recherche recherche) {
        return rechercheService.saveRecherche(recherche);
    }

    @DeleteMapping("/{id}")
    public void deleteRecherche(@PathVariable Long id) {
        rechercheService.deleteRecherche(id);
    }
}
