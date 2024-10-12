package com.employeemanagementsystem.services.impl;
import com.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.employeemanagementsystem.models.Employee;
import com.employeemanagementsystem.repositories.EmployeeRepository;
import com.employeemanagementsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getEmployeesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException{
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()){
            throw new EmployeeNotFoundException("Employee with this id : "+id+" does not exist");
        }
        Employee employee = employeeOptional.get();
        return employee;
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()){
            throw new EmployeeNotFoundException("Employee with this id : "+id+" does not exist");
        }
        Employee savedEmployee = employeeOptional.get();
        savedEmployee.setName(employee.getName());
        savedEmployee.setRole(employee.getRole());
        savedEmployee.setEmail(employee.getEmail());
        savedEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(savedEmployee);
    }

    @Override
    public String deleteEmployeeById(Long id) throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isEmpty()){
            throw new EmployeeNotFoundException("Employee with this id : "+id+" does not exist");
        }
        employeeRepository.delete(employeeOptional.get());
        return "Employee with this id : "+id+" has been deleted successfully";
    }


}
