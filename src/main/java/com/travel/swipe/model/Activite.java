package com.travel.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany
    @JoinTable(
            name = "activite_destination",
            joinColumns = @JoinColumn(name = "activite_id"),
            inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    @JsonManagedReference
    private List<Destination> destinations;



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
