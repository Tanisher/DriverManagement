package com.logistics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class DriverTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "load_id", nullable = false)
    private Load load;

    private String plateNumber;

    @ManyToOne
    private Customer customer;

    // Getters, setters, constructors


    public DriverTrip() {
    }

    public DriverTrip(Long id, LocalDateTime startTime, LocalDateTime endTime, Driver driver, Load load, String plateNumber, Customer customer) {
        this.id = id;

        this.startTime = startTime;
        this.endTime = endTime;
        this.driver = driver;
        this.load = load;
        this.plateNumber = plateNumber;
        this.customer = customer;
    }
}

