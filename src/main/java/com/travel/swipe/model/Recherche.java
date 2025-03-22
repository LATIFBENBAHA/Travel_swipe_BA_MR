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

    public User getUser() {
        return user;
    }

    public String getMotCle() {
        return motCle;
    }

    public Long getRechercheId() {
        return rechercheId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public void setRechercheId(Long rechercheId) {
        this.rechercheId = rechercheId;
    }
}
