package com.travel.swipe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "favorisactivites")
public class FavorisActivite {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        // Lien avec l'utilisateur
        @OneToOne
        @JoinColumn(name = "user_id")
        private User user;

        // Lien avec les activities likée
        @ManyToMany
        @JoinTable(
                name = "favorisactivite_activite",
                joinColumns = @JoinColumn(name = "favorisactivite_id"),
                inverseJoinColumns = @JoinColumn(name = "activite_id")
        )
        @JsonIgnore
        private List<Activite> activites;

        public void add(Activite activite){
                if (this.activites == null){
                        this.activites=new ArrayList<>();
                }
                this.activites.add(activite);
        };
        @Override
        public String toString() {
            return "FavorisActivite{" +
                    "id=" + id +
                    ", user=" + user +
                    ", activite=" + activites +
                    '}';
        }
}
