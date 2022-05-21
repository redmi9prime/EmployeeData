package com.springboot.EmployeeData.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.EmployeeData.EmployeeService.employeeService;
import com.springboot.EmployeeData.Entity.employeeEntity;

@RestController
public class employeeController {
	
	@Autowired
	private employeeService employeeservice;
	
	//exception for particular employee id
	@GetMapping("employee/{id}")
	public employeeEntity checkid(@PathVariable("id") int id) {
		return employeeservice.CheckById(id);
	}
	//display all employee
	@GetMapping("employees")
	public List<employeeEntity> getEmployees(){
		
		List<employeeEntity> list=employeeservice.getAllEmployees();
		return list;
	}
	
	//add new employee
	@PostMapping("addemployee")
	public employeeEntity addEmployee(@RequestBody employeeEntity employee){
		return employeeservice.addOneEmployee(employee);
	
	}
	
	//sort salary in descending
	@GetMapping("employee/salary")
	public List<employeeEntity> getsalary(){
			
		List<employeeEntity> list=employeeservice.getAll();
		return list;
	}
	
	//update a particular employee by id
	@PutMapping("employee/update")
	public employeeEntity update(@RequestBody employeeEntity entity) {
		return employeeservice.updateSalary(entity);
	}

}
