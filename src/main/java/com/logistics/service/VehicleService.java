package com.logistics.service;

import com.logistics.entity.Fault;
import com.logistics.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Optional<Vehicle> getVehicleById(Long id);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    void deleteVehicle(Long id);
    List<Fault> getFaultsByVehicleId(Long vehicleId);
}