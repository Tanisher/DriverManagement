package com.logistics.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Mechanic extends User {
    private String specialization;
    private String certificationLevel;

    public Mechanic() {
        // Always set the role to DRIVER when creating a Driver
        setRole(UserRole.MECHANIC);
    }

}