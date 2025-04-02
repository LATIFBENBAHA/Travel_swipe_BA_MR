package com.travel.swipe.model;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String nom;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Recherche> recherches;


    @Override
    public String toString() {
        return "User{" +
                "Id=" + userId +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", favoris=" + favorites +
                ", recherches=" + recherches +
                '}';
    }
}
