package com.mapping.dto;

import java.util.HashSet;
import java.util.Set;

public class ProjectDto {

	private Long id;
	private String name;
	private String client;
	private Set<EmployeeRecDto> employee = new HashSet();
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
	public Set<EmployeeRecDto> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<EmployeeRecDto> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "ProjectDto [id=" + id + ", name=" + name + ", client=" + client + ", employee=" + employee + "]";
	}
}