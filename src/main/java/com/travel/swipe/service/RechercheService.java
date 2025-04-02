package com.travel.swipe.service;

import com.travel.swipe.model.Recherche;
import com.travel.swipe.repository.RechercheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechercheService {

    private final RechercheRepository rechercheRepository;

    public RechercheService(RechercheRepository rechercheRepository) {
        this.rechercheRepository = rechercheRepository;
    }

    public void deleteRecherche(Long id) {
        rechercheRepository.deleteById(id);
    }

    public Recherche saveRecherche(Recherche recherche) {
        return rechercheRepository.save(recherche);
    }

    public List<Recherche> getRecherchesByUserId(Long userId) {
        return rechercheRepository.findByUser_UserId(userId);
    }
}
