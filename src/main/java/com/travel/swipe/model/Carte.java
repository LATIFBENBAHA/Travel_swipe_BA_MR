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


    public Destination getDestination() { return destination; }
    public void setDestination(Destination destination) { this.destination = destination; }

    public String getUrlCarte() {
        return urlCarte;
    }

    public Long getCarteId() {
        return carteId;
    }

    public void setUrlCarte(String urlCarte) {
        this.urlCarte = urlCarte;
    }
}
