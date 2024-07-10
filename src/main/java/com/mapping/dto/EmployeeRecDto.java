package com.mapping.dto;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRecDto {
	
	private Long id;
	private String name;
	private String role;
	
	private Set<ProjectDto> projects = new HashSet<>();
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<ProjectDto> getProjects() {
		return projects;
	}
	public void setProjects(Set<ProjectDto> projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "EmployeeRecDto [id=" + id + ", name=" + name + ", role=" + role + ", projects=" + projects + "]";
	}
    
}