package com.travel.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "activites")
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // plage, montagne, etc.
    private String description;
    private String imageUrl; //pour stocker l'image de l'activité

    @ManyToMany
    @JoinTable(
            name = "activite_destination",
            joinColumns = @JoinColumn(name = "activite_id"),
            inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
//    @JsonManagedReference
    @JsonIgnore
    private Set<Destination> destinations = new HashSet<>();



    @Override
    public String toString() {
        return "Activite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", destinations=" + destinations +
                '}';
    }
}
