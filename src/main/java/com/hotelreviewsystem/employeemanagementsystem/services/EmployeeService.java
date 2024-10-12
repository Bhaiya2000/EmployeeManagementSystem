package com.hotelreviewsystem.employeemanagementsystem.services;

import com.hotelreviewsystem.employeemanagementsystem.controllers.EmployeeController;
import com.hotelreviewsystem.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.hotelreviewsystem.employeemanagementsystem.models.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
     Employee createEmployee(Employee employee);
     Page<Employee> getEmployeesPaginated(int page, int size);
     Employee getEmployeeById(Long id) throws EmployeeNotFoundException;
     Employee updateEmployeeById(Long id, Employee employee) throws EmployeeNotFoundException;
     String deleteEmployeeById(Long id) throws EmployeeNotFoundException;
}
