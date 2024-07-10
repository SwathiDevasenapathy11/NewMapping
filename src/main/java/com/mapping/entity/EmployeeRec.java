package com.mapping.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

//Recursive many to many relationship

@Entity
public class EmployeeRec {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String role;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="employee_project" , joinColumns = @JoinColumn(name="employee_id") , inverseJoinColumns = @JoinColumn(name="project_id"))
	private Set<Project> project = new HashSet<>();
	
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
	public Set<Project> getProject() {
		return project;
	}
	public void setProject(Set<Project> project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "EmployeeRec [id=" + id + ", name=" + name + ", role=" + role + ", project=" + project + "]";
	}
	
}