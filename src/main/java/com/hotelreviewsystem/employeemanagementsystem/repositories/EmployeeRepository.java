package com.hotelreviewsystem.employeemanagementsystem.repositories;

import com.hotelreviewsystem.employeemanagementsystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

}
