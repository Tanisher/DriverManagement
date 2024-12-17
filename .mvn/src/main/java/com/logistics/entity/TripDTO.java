package com.logistics.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TripDTO {

    private LocalDateTime dateTime;
    private String destination;
    private double startingMillage;
    private double endingMillage;
    private double fuelLitres;
    private String trailer1;
    private String trailer2;
    private Long driverId;
    private Long loadId;
    private String plateNumber;
    private Long customerId;

    // Getters and setters
}
