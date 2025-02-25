package com.travel.swipe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cartes")
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carteId;

    private String urlCarte;

    @OneToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;
}
