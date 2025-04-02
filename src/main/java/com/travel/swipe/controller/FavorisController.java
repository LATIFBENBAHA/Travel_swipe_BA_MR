package com.travel.swipe.controller;

import com.travel.swipe.model.Favorite;
import com.travel.swipe.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoris")
public class FavorisController {

    private final FavoriteService favoriteService;

    public FavorisController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping
    public List<Favorite> getAllFavoris() {
        return favoriteService.getAllFavoris();
    }

    @GetMapping("/user/{userId}")
    public List<Favorite> getFavoritesByUser(@PathVariable Long userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }

    @PostMapping
    public Favorite createFavori(@RequestBody Favorite favorite) {
        return favoriteService.saveFavori(favorite);
    }

    @DeleteMapping("/{id}")
    public void deleteFavori(@PathVariable Long id) {
        favoriteService.deleteFavori(id);
    }
}
