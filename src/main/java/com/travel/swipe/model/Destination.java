package com.travel.swipe.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String pays;
    private String description;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<Activite> activites;

    public Destination() {}

    // Getters et Setters
}
