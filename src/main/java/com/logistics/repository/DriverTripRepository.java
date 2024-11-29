package com.logistics.repository;

import com.logistics.entity.DriverTrip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverTripRepository extends JpaRepository<DriverTrip, Long> {
    List<DriverTrip> findByDriverId(Long driverId); // Custom method to find trips for a specific driver

}
