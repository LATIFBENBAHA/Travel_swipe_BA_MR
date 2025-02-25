package com.travel.swipe.model;

import jakarta.persistence.*;

@Entity
public class Favoris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public Favoris() {}

    // Getters et Setters
}
