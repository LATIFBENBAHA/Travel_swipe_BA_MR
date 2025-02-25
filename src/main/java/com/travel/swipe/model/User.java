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

    public void setNom(String nom) {
    }

    public void setEmail(String email) {
    }
}
