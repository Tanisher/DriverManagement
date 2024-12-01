package com.logistics.service.Impl;

import com.logistics.entity.*;
import com.logistics.repository.DriverRepository;
import com.logistics.repository.UserRepository;
import com.logistics.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, DriverRepository driverRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.driverRepository = driverRepository;
    }

    @Override
    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        switch (user.getRole()) {
            case DRIVER:
                // Convert User to Driver if it's not already a Driver
                Driver driver = user instanceof Driver
                        ? (Driver) user
                        : convertToDriver(user);

                // Set default values if not provided
                if (driver.getName() == null) {
                    driver.setName("Default Name");
                }
                if (driver.getLicenseNumber() == null) {
                    driver.setLicenseNumber("Default License");
                }

                return driverRepository.save(driver);

//            case ADMIN:
//                Admin admin = user instanceof Admin
//                        ? (Admin) user
//                        : convertToAdmin(user);
//                return adminRepository.save(admin);

//            case MECHANIC:
//                Mechanic mechanic = user instanceof Mechanic
//                        ? (Mechanic) user
//                        : convertToMechanic(user);
//                return mechanicRepository.save(mechanic);

//            case OFFICE_STAFF:
//                OfficeStaff officeStaff = user instanceof OfficeStaff
//                        ? (OfficeStaff) user
//                        : convertToOfficeStaff(user);
//                return officeStaffRepository.save(officeStaff);

            default:
                return userRepository.save(user);
        }
    }




    private Driver convertToDriver(User user) {
        Driver driver = new Driver();
        driver.setId(user.getId());
        driver.setUsername(user.getUsername());
        driver.setPassword(user.getPassword());
        driver.setEmail(user.getEmail());
        driver.setRole(User.UserRole.DRIVER);
        return driver;
    }

    private Admin convertToAdmin(User user) {
        Admin admin = new Admin();
        admin.setId(user.getId());
        admin.setUsername(user.getUsername());
        admin.setPassword(user.getPassword());
        admin.setEmail(user.getEmail());
        admin.setRole(User.UserRole.ADMIN);
        return admin;
    }
}
