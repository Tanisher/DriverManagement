package com.logistics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private double weight;
    private String destination;


    @ManyToOne
    private Customer customer;

    // Relationships
    @OneToMany(mappedBy = "load")
    private List<DriverTrip> trips;

    // Getters, setters, constructors
}
