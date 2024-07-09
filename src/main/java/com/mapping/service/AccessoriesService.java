package com.mapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mapping.entity.Accessories;
import com.mapping.entity.AccessoriesUsers;
import com.mapping.repository.IAccessoriesRepository;
import com.mapping.repository.IAccessoryUserRepository;

@Service
public class AccessoriesService {
	
	@Autowired
	private IAccessoriesRepository accessoryRepository;
	
	@Autowired
	private IAccessoryUserRepository userRepository;
	
	public Accessories addAccessory(Accessories accessory) {
		return accessoryRepository.save(accessory);
	}
	
	public AccessoriesUsers addUser(AccessoriesUsers user) {
		return userRepository.save(user);
	}
	
	public ResponseEntity<String> addAccessoryWithUser(Long userId , Long accessoryId) {
		Accessories accessories = accessoryRepository.findById(accessoryId).get();
		AccessoriesUsers user = userRepository.findById(userId).get();
		
		if(user.getAccessories().contains(accessories)) {
			return ResponseEntity.badRequest().body("User already added this " + accessories.getName());
		}
		
//		accessories.getUsers().add(user);
		user.getAccessories().add(accessories);
		
		accessoryRepository.save(accessories);
		userRepository.save(user);
		return ResponseEntity.accepted().body("Added the accessories");
	}
	
	public List<Accessories> getAllAccessories(){
		return accessoryRepository.findAll();
	}
	
	public List<AccessoriesUsers> getUsers(){
		return userRepository.findAll();
	}
}