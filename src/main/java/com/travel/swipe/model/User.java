package com.travel.swipe.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String nom;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Favoris> favoris;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Recherche> recherches;

    public Long getId() { return userId; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Favoris> getFavoris() {
        return favoris;
    }

    public List<Recherche> getRecherches() {
        return recherches;
    }

    public Long getUserId() {
        return userId;
    }

    public void setFavoris(List<Favoris> favoris) {
        this.favoris = favoris;
    }

    public void setRecherches(List<Recherche> recherches) {
        this.recherches = recherches;
    }
}
