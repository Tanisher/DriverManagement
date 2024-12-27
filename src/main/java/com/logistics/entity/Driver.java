

package com.logistics.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Driver extends User {

    private String name;
    private String lastName;
    private String address;
    private String licenseNumber;
    private String nextOfKin;
    private String nextOfKinContact;
    private String mobileNumber;
    private String idNumber;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = true) // A driver may or may not have a vehicle
    private Vehicle vehicle;

    @OneToMany(mappedBy = "driver")
    private List<Fault> faults;

    public Driver() {
        setRole(UserRole.DRIVER);
    }
}
