package com.logistics.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("MECHANIC")
public class Mechanic extends User {
    private String specialization;
    private String certificationLevel;

}