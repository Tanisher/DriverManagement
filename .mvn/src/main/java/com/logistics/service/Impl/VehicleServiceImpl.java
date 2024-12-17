package com.logistics.service.Impl;

import com.logistics.entity.Driver;
import com.logistics.entity.Fault;
import com.logistics.entity.Vehicle;
import com.logistics.repository.DriverRepository;
import com.logistics.repository.FaultRepository;
import com.logistics.repository.VehicleRepository;
import com.logistics.service.VehicleService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private FaultRepository faultRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        if (vehicleRepository.existsByLicensePlate(vehicle.getLicensePlate())) {
            throw new IllegalArgumentException("Vehicle with the same license plate already exists.");
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found."));

        existingVehicle.setLicensePlate(vehicle.getLicensePlate());
        existingVehicle.setMake(vehicle.getMake());
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setYear(vehicle.getYear());
        existingVehicle.setColor(vehicle.getColor());
        existingVehicle.setActive(vehicle.isActive());
        existingVehicle.setLastServiceDate(vehicle.getLastServiceDate());

        return vehicleRepository.save(existingVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new IllegalArgumentException("Vehicle not found.");
        }
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<Fault> getFaultsByVehicleId(Long vehicleId) {
        return faultRepository.findByVehicleId(vehicleId);
    }

    @Override
    public void updateVehicleLocation(Long vehicleId, Double latitude, Double longitude) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicle.setLatitude(latitude);
        vehicle.setLongitude(longitude);
        vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle findById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    @Override
    @Transactional
    public Vehicle assignDriverToVehicle(Long vehicleId, Long driverId) {
        // Find the vehicle
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found with id: " + vehicleId));

        // Find the driver
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Driver not found with id: " + driverId));

        // Check if the driver is already assigned to another vehicle
        Optional<Vehicle> existingVehicleWithDriver = vehicleRepository.findByDriver(driver);
        if (existingVehicleWithDriver.isPresent()) {
            // If driver is already assigned, you might want to unassign them from the previous vehicle
            existingVehicleWithDriver.get().setDriver(null);
        }

        // Assign the driver to the vehicle
        vehicle.setDriver(driver);

        // Save and return the updated vehicle
        return vehicleRepository.save(vehicle);
    }
}
