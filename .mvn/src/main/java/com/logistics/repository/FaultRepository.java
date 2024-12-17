package com.logistics.repository;

import com.logistics.entity.Fault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaultRepository extends JpaRepository<Fault, Long> {
    List<Fault> findByResolved(boolean resolved); // Find all faults by resolved status
    List<Fault> findByVehicleId(Long vehicleId);
}
