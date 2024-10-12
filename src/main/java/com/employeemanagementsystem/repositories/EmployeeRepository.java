package com.employeemanagementsystem.repositories;

import com.employeemanagementsystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

}
