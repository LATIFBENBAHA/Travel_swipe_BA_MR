package com.travel.swipe.service;

import com.travel.swipe.model.Carte;
import com.travel.swipe.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteService {

    private final CarteRepository carteRepository;

    @Autowired
    public CarteService(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    public Carte saveCarte(Carte carte) {
        return carteRepository.save(carte);
    }

    public List<Carte> getAllCartes() {
        return carteRepository.findAll();
    }

    public Carte getCarteById(Long id) {
        return carteRepository.findById(id).orElse(null);
    }

    public Carte updateCarte(Long id, Carte carte) {
        Optional<Carte> existingCarte = carteRepository.findById(id);
        if (existingCarte.isPresent()) {
            Carte updatedCarte = existingCarte.get();
            updatedCarte.setNom(carte.getNom());  // Exemple : mettez à jour selon les champs
            updatedCarte.setDestination(carte.getDestination());  // Exemple : mettez à jour selon les champs
            return carteRepository.save(updatedCarte);
        }
        return null;
    }

    public void deleteCarte(Long id) {
        carteRepository.deleteById(id);
    }
}
