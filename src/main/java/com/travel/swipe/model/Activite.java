package com.travel.swipe.model;

import jakarta.persistence.*;

@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public Activite() {}

    // Getters et Setters
}
