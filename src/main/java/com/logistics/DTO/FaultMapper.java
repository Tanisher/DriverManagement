package com.logistics.DTO;


import com.logistics.entity.Driver;
import com.logistics.entity.Fault;
import com.logistics.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class FaultMapper {

    public FaultDTO toDTO(Fault fault) {
        if (fault == null) {
            return null;
        }

        FaultDTO dto = new FaultDTO();
        dto.setId(fault.getId());
        dto.setDescription(fault.getDescription());
        dto.setReportedAt(fault.getReportedAt());
        dto.setResolved(fault.isResolved());
        dto.setResolutionNotes(fault.getResolutionNotes());

        // Safely handle nested objects
        if (fault.getVehicle() != null) {
            dto.setVehicleId(fault.getVehicle().getId());
        }

        if (fault.getDriver() != null) {
            dto.setDriverId(fault.getDriver().getId());
        }

        return dto;
    }

    public Fault toEntity(FaultDTO dto) {
        if (dto == null) {
            return null;
        }

        Fault fault = new Fault();
        fault.setId(dto.getId());
        fault.setDescription(dto.getDescription());
        fault.setReportedAt(dto.getReportedAt());
        fault.setResolved(dto.isResolved());
        fault.setResolutionNotes(dto.getResolutionNotes());

        // Create reference objects for relationships
        // Note: Only IDs are set here, the actual objects should be loaded by the service layer
        if (dto.getVehicleId() != null) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(dto.getVehicleId());
            fault.setVehicle(vehicle);
        }

        if (dto.getDriverId() != null) {
            Driver driver = new Driver();
            driver.setId(dto.getDriverId());
            fault.setDriver(driver);
        }

        return fault;
    }
}