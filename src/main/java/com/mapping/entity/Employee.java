//one to one relationship
package com.mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public String password;
	
	@OneToOne
	@JoinColumn(name="employeeId")
	private EmployeeDetails employeeDetails;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public EmployeeDetails getEmployeeDetails() {
//		return employeeDetails;
//	}
//	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
//		this.employeeDetails = employeeDetails;
//	}
}