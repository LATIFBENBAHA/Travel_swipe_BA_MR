package com.travel.swipe.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destinationId;

    private String nom;
    private String pays;
    private String type;
    private double latitude;
    private double longitude;
    private String description;

    @OneToOne(mappedBy = "destination", cascade = CascadeType.ALL)
    private Carte carte;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<Activite> activites;

    public String getNom() {
        return nom;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Carte getCarte() {
        return carte;
    }

    public String getType() {
        return type;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getDescription() {
        return description;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public String getPays() {
        return pays;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
