package com.travel.swipe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String motdepass;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private FavorisActivite favorisActivites;
    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private FavorisDestination favorisDestinations;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + name + '\'' +
                ", email='" + email + '\'' +
                ", favorisActivites=" + favorisActivites +
                '}';
    }
}
