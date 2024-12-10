package com.logistics.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Admin extends User {
    private String Name;
    private String department;
    private boolean isSuperAdmin;

    public Admin() {
        // Always set the role to DRIVER when creating a Driver
        setRole(UserRole.ADMIN);
    }


}