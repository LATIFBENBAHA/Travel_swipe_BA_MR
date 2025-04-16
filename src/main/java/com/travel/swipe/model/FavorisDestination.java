package com.travel.swipe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "favorisdestinations")
public class FavorisDestination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "favorisdestination_destination",
            joinColumns = @JoinColumn(name = "favorisdestination_id"),
            inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    private List<Destination> destinations;

    public void add(Destination destination){
        this.destinations.add(destination);
    };
    @Override
    public String toString() {
        return "FavorisDestination{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", destination=" + destinations +
                '}';
    }
}
