package com.logistics.service;

import com.logistics.entity.Driver;

import java.util.List;

public interface DriverService {
    Driver saveDriver(Driver driver);
    List<Driver> getAllDrivers();
    Driver getDriverById(Long id);
    void deleteDriver(Long id);
}