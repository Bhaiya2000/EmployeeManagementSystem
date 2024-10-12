package com.employeemanagementsystem.controllers;

import com.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.employeemanagementsystem.models.Employee;
import com.employeemanagementsystem.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;


    @Test
    public void testCreateEmployee() {
        Employee employee =  new Employee();
        employeeController.createEmployee(employee);
    }

    @Test
    public void testGetEmployeesPaginated() {
        employeeController.getEmployeesPaginated(1,2);
    }

    @Test
    public void testGetEmployeeById() throws EmployeeNotFoundException {
        employeeController.getEmployeeById(1L);
    }

    @Test
    public void testUpdateEmployeeById() throws EmployeeNotFoundException {
        Employee employee =  new Employee();
        employeeController.updateEmployeeById(1L,employee);
    }

    @Test
    public void testDeleteEmployeeById() throws EmployeeNotFoundException {
        employeeController.deleteEmployeeById(1L);
    }
}