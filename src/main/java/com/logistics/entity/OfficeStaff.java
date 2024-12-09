package com.logistics.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OfficeStaff extends User {
    private String officeLocation;
    private String position;

    public OfficeStaff() {
        // Always set the role to DRIVER when creating a Driver
        setRole(UserRole.OFFICE);
    }


}