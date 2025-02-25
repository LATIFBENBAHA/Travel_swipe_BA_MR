package com.travel.swipe.model;
import jakarta.persistence.*;

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
}
