//package com.logistics.controllers;
//
//import com.logistics.entity.User;
//import com.logistics.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api")
//public class UserController1 {
//
//    @Autowired
//    private UserService userService;
//
//    // Common endpoint for all authenticated users
//    @GetMapping("/profile")
//    public ResponseEntity<?> getUserProfile() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUsername = authentication.getName();
//        User currentUser = userService.findByUsername(currentUsername);
//
//        return ResponseEntity.ok(currentUser);
//    }
//
//    // Admin-specific endpoints
//    @RestController
//    @RequestMapping("/api/admin")
//    @PreAuthorize("hasAuthority('ADMIN')")
//    public class AdminController {
//
//        @GetMapping("/dashboard")
//        public ResponseEntity<?> getAdminDashboard() {
//            // Fetch admin-specific dashboard data
//            return ResponseEntity.ok("Admin Dashboard");
//        }
//
//        @PostMapping("/create-user")
//        public ResponseEntity<?> createUser(@RequestBody User user) {
//            // Only admins can create new users
//            User createdUser = userService.registerUser(user);
//            return ResponseEntity.ok(createdUser);
//        }
//
//        @GetMapping("/users")
//        public ResponseEntity<?> getAllUsers() {
//            // Fetch all users (admin-only)
//            return ResponseEntity.ok(userService.findAllUsers());
//        }
//    }
//
//    // Driver-specific endpoints
//    @RestController
//    @RequestMapping("/api/driver")
//    @PreAuthorize("hasAuthority('DRIVER')")
//    public class DriverController {
//
//        @GetMapping("/trips")
//        public ResponseEntity<?> getDriverTrips() {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            String currentUsername = authentication.getName();
//
//            // Fetch trips for the current driver
//            return ResponseEntity.ok("Driver Trips");
//        }
//
//        @PostMapping("/log-trip")
//        public ResponseEntity<?> logTrip(@RequestBody Object tripDetails) {
//            // Log a new trip for the driver
//            return ResponseEntity.ok("Trip Logged");
//        }
//    }
//
//    // Mechanic-specific endpoints
//    @RestController
//    @RequestMapping("/api/mechanic")
//    @PreAuthorize("hasAuthority('MECHANIC')")
//    public class MechanicController {
//
//        @GetMapping("/vehicle-maintenance")
//        public ResponseEntity<?> getVehicleMaintenance() {
//            // Fetch vehicle maintenance tasks
//            return ResponseEntity.ok("Vehicle Maintenance Tasks");
//        }
//
//        @PostMapping("/log-maintenance")
//        public ResponseEntity<?> logMaintenance(@RequestBody Object maintenanceDetails) {
//            // Log vehicle maintenance
//            return ResponseEntity.ok("Maintenance Logged");
//        }
//    }
//
//    // Office Staff-specific endpoints
//    @RestController
//    @RequestMapping("/api/office")
//    @PreAuthorize("hasAuthority('OFFICE')")
//    public class OfficeStaffController {
//
//        @GetMapping("/reports")
//        public ResponseEntity<?> getReports() {
//            // Fetch office reports
//            return ResponseEntity.ok("Office Reports");
//        }
//
//        @PostMapping("/create-report")
//        public ResponseEntity<?> createReport(@RequestBody Object reportDetails) {
//            // Create a new report
//            return ResponseEntity.ok("Report Created");
//        }
//    }
//}