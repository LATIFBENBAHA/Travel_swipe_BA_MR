package com.travel.swipe.controller;

import com.travel.swipe.model.Carte;
import com.travel.swipe.service.CarteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartes")
public class CarteController {

    private final CarteService carteService;

    public CarteController(CarteService carteService) {
        this.carteService = carteService;
    }

    @GetMapping
    public List<Carte> getAllCartes() {
        return carteService.getAllCartes();
    }

    @GetMapping("/{id}")
    public Carte getCarteById(@PathVariable Long id) {
        return carteService.getCarteById(id);
    }

    @PostMapping("/cartes")
    public ResponseEntity<Carte> createCarte(@RequestBody Carte carte) {
        try {
            Carte savedCarte = carteService.saveCarte(carte);
            return new ResponseEntity<>(savedCarte, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public Carte updateCarte(@PathVariable Long id, @RequestBody Carte carte) {
        return carteService.updateCarte(id, carte);
    }

    @DeleteMapping("/{id}")
    public void deleteCarte(@PathVariable Long id) {
        carteService.deleteCarte(id);
    }
}
