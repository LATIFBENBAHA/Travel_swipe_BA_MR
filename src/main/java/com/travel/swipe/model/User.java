package com.travel.swipe.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Favoris> favoris;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Recherche> recherches;

    public User() {}

    // Getters et Setters
}