package com.logistics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.print.attribute.standard.Destination;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class DriverTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private Destination destination;
    private String StartingMillage;
    private String EndingMillage;

    private int FuelLitres;

    private String trailer1;
    private String trailer2;


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

    public DriverTrip(Long id, LocalDateTime dateTime, Destination destination, String startingMillage, String endingMillage, int fuelLitres, String trailer1, String trailer2, Driver driver, Load load, String plateNumber, Customer customer) {
        this.id = id;
        this.dateTime = dateTime;
        this.destination = destination;
        StartingMillage = startingMillage;
        EndingMillage = endingMillage;
        FuelLitres = fuelLitres;
        this.trailer1 = trailer1;
        this.trailer2 = trailer2;
        this.driver = driver;
        this.load = load;
        this.plateNumber = plateNumber;
        this.customer = customer;
    }
}

