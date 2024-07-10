package com.mapping.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

//Recursive Many to many relation
@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String client;
	
	@ManyToMany(mappedBy = "project")
	private Set<EmployeeRec> employee = new HashSet<>();
	
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
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public Set<EmployeeRec> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<EmployeeRec> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", client=" + client + ", employee=" + employee + "]";
	}
	
	
    
}
