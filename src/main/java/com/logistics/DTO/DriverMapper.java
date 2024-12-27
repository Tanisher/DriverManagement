package com.logistics.DTO;

import com.logistics.entity.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    public DriverDTO toDTO(Driver driver) {
        if (driver == null) {
            return null;
        }

        DriverDTO dto = new DriverDTO();
        dto.setId(driver.getId());
        dto.setName(driver.getName());
        dto.setLastName(driver.getLastName());
        dto.setIdNumber(driver.getIdNumber());
        dto.setLicenseNumber(driver.getLicenseNumber());
        dto.setMobileNumber(driver.getMobileNumber());
        dto.setAddress(driver.getAddress());
        dto.setNextOfKin(driver.getNextOfKin());
        dto.setNextOfKinContact(driver.getNextOfKinContact());

        // Map User properties directly since Driver extends User
        UserDTO userDTO = new UserDTO();
        userDTO.setId(driver.getId());  // Same ID since it's inheritance
        userDTO.setUsername(driver.getUsername());
        userDTO.setEmail(driver.getEmail());
        userDTO.setRole(driver.getRole());
        dto.setUser(userDTO);

        return dto;
    }

    public Driver toEntity(DriverDTO dto) {
        if (dto == null) {
            return null;
        }

        Driver driver = new Driver();
        driver.setId(dto.getId());
        driver.setName(dto.getName());
        driver.setLastName(dto.getLastName());
        driver.setIdNumber(dto.getIdNumber());
        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setMobileNumber(dto.getMobileNumber());
        driver.setAddress(dto.getAddress());
        driver.setNextOfKin(dto.getNextOfKin());
        driver.setNextOfKinContact(dto.getNextOfKinContact());

        // Map User properties directly
        if (dto.getUser() != null) {
            driver.setUsername(dto.getUser().getUsername());
            driver.setEmail(dto.getUser().getEmail());
            driver.setRole(dto.getUser().getRole());
        }

        return driver;
    }
}