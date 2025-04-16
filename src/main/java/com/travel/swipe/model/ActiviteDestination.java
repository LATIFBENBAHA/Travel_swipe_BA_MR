package com.travel.swipe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "activite_destination")
public class ActiviteDestination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "activite_id")
    private Long activiteId;
    @Column(name = "destination_id")
    private Long destinationId;

    public ActiviteDestination() {}

    public ActiviteDestination(Long activiteId, Long destinationId) {
        this.activiteId = activiteId;
        this.destinationId = destinationId;
    }


}
