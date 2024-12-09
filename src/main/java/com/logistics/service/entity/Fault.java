package com.logistics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Fault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private DriverTrip trip;

    @Column(nullable = false)
    private String description; // Description of the fault or breakdown

    @Column(nullable = false)
    private LocalDateTime reportedAt; // Time the fault was reported

    private boolean resolved = false; // Indicates if the fault has been resolved

    @Column(length = 500)
    private String resolutionNotes; // Notes on how the fault was resolved

}