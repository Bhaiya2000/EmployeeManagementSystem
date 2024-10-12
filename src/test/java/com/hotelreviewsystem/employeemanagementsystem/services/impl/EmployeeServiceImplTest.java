package com.hotelreviewsystem.employeemanagementsystem.services.impl;

import com.hotelreviewsystem.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.hotelreviewsystem.employeemanagementsystem.models.Employee;
import com.hotelreviewsystem.employeemanagementsystem.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee();
        employeeService.createEmployee(employee);
    }

    @Test
    public void testGetEmployeesPaginated() {
        employeeService.getEmployeesPaginated(1,2);
    }

    @Test
    public void testGetEmployeeById() throws EmployeeNotFoundException {
        assertThrows(Exception.class, ()->{
            employeeService.getEmployeeById(1L);
        }) ;
    }

    @Test
    public void testGetEmployeeByIdReverseCase() throws EmployeeNotFoundException {
        Optional<Employee> employeeOptional = Optional.of(new Employee());
        Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(employeeOptional);
        employeeService.getEmployeeById(1L);
    }

    @Test
    public void testUpdateEmployeeById() throws EmployeeNotFoundException {
        Employee employee = new Employee();
        assertThrows(EmployeeNotFoundException.class, ()->{
            employeeService.updateEmployeeById(1L, employee);
        });
    }

    @Test
    public void testUpdateEmployeeByIdReverseCase() throws EmployeeNotFoundException {
        Employee employee = new Employee();
        Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(employee));
        employeeService.updateEmployeeById(1L, employee);
    }

    @Test
    public  void testDeleteEmployeeById() throws EmployeeNotFoundException {
        assertThrows(EmployeeNotFoundException.class, ()->{
            employeeService.deleteEmployeeById(1L);
        });
    }

    @Test
    public  void testDeleteEmployeeByIdReverseCase() throws EmployeeNotFoundException {
        Employee employee = new Employee();
        Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(employee));
        employeeService.deleteEmployeeById(1L);
    }
}