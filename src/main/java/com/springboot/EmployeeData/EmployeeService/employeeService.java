package com.springboot.EmployeeData.EmployeeService;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.springboot.EmployeeData.Entity.employeeEntity;
import com.springboot.EmployeeData.Exception.ResourceNotFoundException;
import com.springboot.EmployeeData.Repository.employeeRepository;

@Component
public class employeeService {
	
	@Autowired
	private employeeRepository employeerepository;
	
	//ResourceNotFoundException
	public employeeEntity CheckById(int id) {
		
		return this.employeerepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Employee doesn't exists in the database"));
	}
	
	//get all employees
	public List<employeeEntity> getAllEmployees(){	
		List<employeeEntity> list=this.employeerepository.findAll();
		return list;
		
	}
	
	//addemployee
	public employeeEntity addOneEmployee(employeeEntity employee) {
		 return employeerepository.save(employee);
	
	}
	
	
	//sorting in desc
	public List<employeeEntity> getAll(){
		
		List<employeeEntity> list=(List<employeeEntity>) this.employeerepository.findAll();
		Collections.sort(list, (emp1,emp2) -> Double.compare(emp2.getSalary(),emp1.getSalary()));
		return list;
		
	}
	
	//update salary by id
	public employeeEntity updateSalary(employeeEntity entity) {
		employeeEntity oldemployee=null;
		Optional<employeeEntity> optionalemployee=employeerepository.findById((int) entity.getId());
		if(optionalemployee.isPresent()) {
			oldemployee=optionalemployee.get();
			oldemployee.setSalary(entity.getSalary());
			employeerepository.save(oldemployee);
		}
		else {
			return new employeeEntity();
		}
		return oldemployee;
	}

}
