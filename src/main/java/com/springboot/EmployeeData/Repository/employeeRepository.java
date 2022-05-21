package com.springboot.EmployeeData.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.EmployeeData.Entity.employeeEntity;

public interface employeeRepository extends JpaRepository<employeeEntity, Integer>{

}
