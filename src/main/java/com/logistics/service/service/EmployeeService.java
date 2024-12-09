package com.logistics.service;

import com.logistics.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
}