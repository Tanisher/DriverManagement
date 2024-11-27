package com.logistics.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class DriverTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startLocation;
    private String endLocation;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Load load;

    private String plateNumber;


    // Getters, setters, constructors
}

