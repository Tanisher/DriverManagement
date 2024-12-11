package com.logistics.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoadDTO {
    private Long id;
    private Long customerId;
    private String description;
    private String weight;
    private String pickupLocation;
    private String deliveryLocation;
    private String status;
    private String customerName; // Optional: include customer name if needed

    // Constructors, getters, and setters

    public LoadDTO() {
    }

    public LoadDTO(Long id, Long customerId, String description, String weight, String pickupLocation, String deliveryLocation, String status, String customerName) {
        this.id = id;
        this.customerId = customerId;
        this.description = description;
        this.weight = weight;
        this.pickupLocation = pickupLocation;
        this.deliveryLocation = deliveryLocation;
        this.status = status;
        this.customerName = customerName;
    }
}