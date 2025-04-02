package com.travel.swipe.service;

import com.travel.swipe.model.Favorite;
import com.travel.swipe.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<Favorite> getAllFavoris() {
        return favoriteRepository.findAll();
    }

    public List<Favorite> getFavoritesByUserId(Long userId) {
        return favoriteRepository.findByUser_UserId(userId);
    }

    public Favorite saveFavori(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    public void deleteFavori(Long id) {
        favoriteRepository.deleteById(id);
    }
}
