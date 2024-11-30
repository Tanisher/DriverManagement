package com.logistics.controllers;

import com.logistics.entity.DriverTrip;
import com.logistics.service.DriverTripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver-trips")
public class DriverTripController {
    private final DriverTripService driverTripService;

    public DriverTripController(DriverTripService driverTripService) {
        this.driverTripService = driverTripService;
    }

    @PostMapping
    public DriverTrip createDriverTrip(@RequestBody DriverTrip driverTrip) {
        return driverTripService.saveDriverTrip(driverTrip);
    }

    @GetMapping
    public List<DriverTrip> getAllDriverTrips() {
        return driverTripService.getAllDriverTrips();
    }

    @GetMapping("/{id}")
    public DriverTrip getDriverTripById(@PathVariable Long id) {
        return driverTripService.getDriverTripById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDriverTrip(@PathVariable Long id) {
        driverTripService.deleteDriverTrip(id);
    }

    // New endpoint to get trips for a specific driver
    @GetMapping("/driver/{driverId}")
    public List<DriverTrip> getTripsByDriverId(@PathVariable Long driverId) {
        return driverTripService.getTripsByDriverId(driverId);
    }
}