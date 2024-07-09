//Many to many example

package com.mapping.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class AccessoriesUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;
	
	@ManyToMany
	@JoinTable(name="user_accessories" , joinColumns = @JoinColumn(name="user_id") , inverseJoinColumns = @JoinColumn(name="accessory_id") )
	private Set<Accessories> accessories = new HashSet<>();	
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Set<Accessories> getAccessories() {
		return accessories;
	}
	public void setAccessories(Set<Accessories> accessories) {
		this.accessories = accessories;
	}
}