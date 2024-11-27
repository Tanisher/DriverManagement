package com.logistics.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String address;
    private String licenseNumber;
    private String nextOfKin;
    private String nextOfKinContact;
    private String mobileNumber;

    private String IDNumber;
    private String employeeNumber;


    @OneToMany(mappedBy = "driver")
    private List<DriverTrip> trips;





}
