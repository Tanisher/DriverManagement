package com.logistics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;
    private String email;
    private String phone;
    private String address;
    private String IDNumber;
    private Date startDate;

    public Employee() {
    }

    public Employee(String name, String position, String email, String phone) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.IDNumber = IDNumber;
        this.startDate = new Date();

    }
}
