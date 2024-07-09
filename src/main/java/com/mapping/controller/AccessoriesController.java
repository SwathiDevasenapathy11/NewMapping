package com.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.entity.Accessories;
import com.mapping.entity.AccessoriesUsers;
import com.mapping.service.AccessoriesService;

@RestController
@RequestMapping("/accessories")
public class AccessoriesController {
	
	@Autowired
	private AccessoriesService accessoriesService;
	
	@PostMapping("/addAccesssories")
	public Accessories add(@RequestBody Accessories accessory) {
		return accessoriesService.addAccessory(accessory);
	}
	
	@PostMapping("/addUser")
	public AccessoriesUsers addUser(@RequestBody AccessoriesUsers user) {
		return accessoriesService.addUser(user);
	}
	
	@PostMapping("/{userId}/accessory/{accessoryId}")
	public ResponseEntity<String> userWithAccessory(@PathVariable Long userId ,@PathVariable Long accessoryId){
		return accessoriesService.addAccessoryWithUser(userId, accessoryId);
	}
	
	@GetMapping("/getAccessories")
	public List<Accessories> getAccessories(){
		return accessoriesService.getAllAccessories();
	}
	
	@GetMapping("/getUsers")
	public List<AccessoriesUsers> getUsers(){
		return accessoriesService.getUsers();
	}

}
