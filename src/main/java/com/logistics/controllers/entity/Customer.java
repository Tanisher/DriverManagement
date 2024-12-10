package com.logistics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;
    private String address;
    private String numberOfLoads;
    private String email;

    // Relationships
    @OneToMany(mappedBy = "customer")
    private List<Load> loads;

    @OneToMany(mappedBy = "customer")
    private List<DriverTrip>driverTrips;

    // Getters, setters, constructors
}

