package com.travel.swipe.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "activites")
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activiteId;

    private String nom;
    private String description;

    @ManyToOne
    @JsonIgnore // Évite la récursion infinie
    @JoinColumn(name = "destination_id")
    private Destination destination;

}

