package com.logistics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "logistics_load")
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String weight;
    private String pickupLocation;
    private String deliveryLocation;
    private String status; // e.g., "Pending", "In Transit", "Delivered"



    @ManyToOne
    private Customer customer;

    // Relationships
    @OneToMany(mappedBy = "load")
    private List<DriverTrip> trips;

    // Getters, setters, constructors
}
