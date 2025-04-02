package com.travel.swipe.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    @Override
    public String toString() {
        return "Destination{" +
                "id=" + destinationId +
                ", nom='" + nom + '\'' +
                ", pays='" + pays + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
