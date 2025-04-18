package com.travel.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String country;
    private String description;
    private String imageUrl; // pour stocker l'image de la destinat


////    @JoinTable(
////            name = "activite_destination",
////            joinColumns = @JoinColumn(name = "destination_id"),
////            inverseJoinColumns = @JoinColumn(name = "activite_id")
////    )
//////    @JsonIgnore
////    @JsonBackReference
    @ManyToMany(mappedBy = "destinations")
    private Set<Activite> activites = new HashSet<>();
}
