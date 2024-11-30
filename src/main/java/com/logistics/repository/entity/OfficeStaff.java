package com.logistics.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("OFFICE")
@Getter
@Setter
public class OfficeStaff extends User {
    private String officeLocation;
    private String position;


}