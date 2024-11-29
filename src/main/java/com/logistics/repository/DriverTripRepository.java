package com.logistics.repository;

import com.logistics.entity.DriverTrip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverTripRepository extends JpaRepository<DriverTrip, Long> {
}
