package com.mapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.entity.Employee;
import com.mapping.entity.EmployeeDetails;
import com.mapping.repository.IEmployeeDetailsRepository;
import com.mapping.repository.IEmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Autowired
	private IEmployeeDetailsRepository employeeDetailsRepo;
	
	public Employee add(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public EmployeeDetails addDetails(EmployeeDetails employeeDetails) {
		employeeDetails.setEmployee(employeeRepository.findById(employeeDetails.getEmployee().getId()).orElse(null));
		return employeeDetailsRepo.save(employeeDetails);
	}
	
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
	}
	
	public List<EmployeeDetails> getEmployeeDetails(){
		return employeeDetailsRepo.findAll();
	}
}

