package com.logistics.service;

import com.logistics.entity.DriverTrip;

import java.util.List;

public interface DriverTripService {
    DriverTrip saveDriverTrip(DriverTrip driverTrip);
    List<DriverTrip> getAllDriverTrips();
    DriverTrip getDriverTripById(Long id);
    void deleteDriverTrip(Long id);
    List<DriverTrip> getTripsByDriverId(Long driverId); // New method to fetch trips by driver ID
}
