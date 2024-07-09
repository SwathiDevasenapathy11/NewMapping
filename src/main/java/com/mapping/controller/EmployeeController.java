//One to One Example (Employee and their details)

package com.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.entity.Employee;
import com.mapping.entity.EmployeeDetails;
import com.mapping.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
    public Employee add(@RequestBody Employee employee) {
    	return employeeService.add(employee);
    }
	
	@PostMapping("/addDetails")
	public EmployeeDetails addDetails(@RequestBody EmployeeDetails employeeDetails) {
		return employeeService.addDetails(employeeDetails);
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getAll(){
		return employeeService.getEmployee();
	}
	
	@GetMapping("/getEmployeeDetails")
	public List<EmployeeDetails> getEmployeeDetails(){
		return employeeService.getEmployeeDetails();
	}
}
