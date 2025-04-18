package com.travel.swipe.service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.travel.swipe.model.Activite;
import com.travel.swipe.model.FavorisActivite;
import com.travel.swipe.model.User;
import com.travel.swipe.repository.ActiviteRepository;
import com.travel.swipe.repository.FavorisActiviteRepository;
import com.travel.swipe.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Service
public class FavorisActiviteService {

    @Autowired
    private FavorisActiviteRepository favorisActiviteRepository;

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void likerActivite(Long userId, Long activiteId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + userId));

        Activite activite = activiteRepository.findById(activiteId)
                .orElseThrow(() -> new RuntimeException("Activité non trouvée avec l'ID : " + activiteId));

        FavorisActivite favorisActivite = favorisActiviteRepository.findByUser(user);

        if (favorisActivite == null) {
            favorisActivite = new FavorisActivite();
            favorisActivite.setActivites(new ArrayList<>());
            favorisActivite.setUser(user);
        }

        if (!favorisActivite.getActivites().contains(activite)) {
            favorisActivite.add(activite);
            favorisActiviteRepository.save(favorisActivite);

        }
    }
    public void unlikerActivite(Long userId, Long activiteId) {
        FavorisActivite favoris = favorisActiviteRepository.findByUserId(userId);
        if (favoris != null && favoris.getActivites() != null) {
            favoris.getActivites().removeIf(a -> a.getId().equals(activiteId));
            favorisActiviteRepository.save(favoris); // Important pour mettre à jour la relation ManyToMany
        }
    }





    public List<Activite> getActivitesLikees(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        if (isNull(favorisActiviteRepository.findByUser(user))){
            return null;
        }
        return favorisActiviteRepository.findByUser(user).getActivites();
    }
    public List<FavorisActivite> getAllFavorisActivites(){return favorisActiviteRepository.findAll();}

}
