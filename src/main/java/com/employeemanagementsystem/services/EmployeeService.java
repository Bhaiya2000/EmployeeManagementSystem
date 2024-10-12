package com.employeemanagementsystem.services;

import com.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.employeemanagementsystem.models.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
     Employee createEmployee(Employee employee);
     Page<Employee> getEmployeesPaginated(int page, int size);
     Employee getEmployeeById(Long id) throws EmployeeNotFoundException;
     Employee updateEmployeeById(Long id, Employee employee) throws EmployeeNotFoundException;
     String deleteEmployeeById(Long id) throws EmployeeNotFoundException;
}
