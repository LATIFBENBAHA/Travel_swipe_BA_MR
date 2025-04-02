package com.travel.swipe.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recherches")
public class Recherche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rechercheId;

    private String motCle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Recherche{" +
                "rechercheId=" + rechercheId +
                ", motCle='" + motCle + '\'' +
                ", user=" + user +
                '}';
    }
}
