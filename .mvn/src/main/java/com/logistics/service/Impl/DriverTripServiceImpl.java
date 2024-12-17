package com.logistics.service.Impl;

import com.logistics.entity.DriverTrip;
import com.logistics.repository.DriverTripRepository;
import com.logistics.service.DriverTripService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverTripServiceImpl implements DriverTripService {
    private final DriverTripRepository driverTripRepository;

    public DriverTripServiceImpl(DriverTripRepository driverTripRepository) {
        this.driverTripRepository = driverTripRepository;
    }

    @Override
    public DriverTrip saveDriverTrip(DriverTrip driverTrip) {
        return driverTripRepository.save(driverTrip);
    }

    @Override
    public List<DriverTrip> getAllDriverTrips() {
        return driverTripRepository.findAll();
    }

    @Override
    public DriverTrip getDriverTripById(Long id) {
        return driverTripRepository.findById(id).orElseThrow(() -> new RuntimeException("DriverTrip not found"));
    }

    @Override
    public void deleteDriverTrip(Long id) {
        driverTripRepository.deleteById(id);
    }

    @Override
    public List<DriverTrip> getTripsByDriverId(Long driverId) {
        return driverTripRepository.findByDriverId(driverId); // Fetch trips for the specified driver
    }
}
