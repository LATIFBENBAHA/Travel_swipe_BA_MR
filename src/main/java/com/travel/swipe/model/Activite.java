package com.travel.swipe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activites")
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activiteId;

    private String nom;
    private String description;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;
}

