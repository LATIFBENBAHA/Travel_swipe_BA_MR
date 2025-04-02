package com.travel.swipe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cartes")
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carteId;
    private String nom;
    private String urlCarte;
    @OneToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @Override
    public String toString() {
        return "Carte{" +
                "carteId=" + carteId +
                ", nom='" + nom + '\'' +
                ", urlCarte='" + urlCarte + '\'' +
                ", destination=" + destination +
                '}';
    }
}
