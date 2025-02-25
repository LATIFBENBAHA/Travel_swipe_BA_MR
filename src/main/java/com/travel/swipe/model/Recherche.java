package com.travel.swipe.model;
import jakarta.persistence.*;

@Entity
public class Recherche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String motsCles;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Recherche() {}

    // Getters et Setters
}