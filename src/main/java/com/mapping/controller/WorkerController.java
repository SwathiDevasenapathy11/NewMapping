//One to many example (One owner for many workers)

package com.mapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.entity.Owner;
import com.mapping.entity.Worker;
import com.mapping.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	
	@Autowired
	private WorkerService workerService;
	
	@PostMapping("/addWorker")
	public Worker addWorker(@RequestBody Worker worker) {
		return workerService.addWorker(worker);
	}
	
	@PostMapping("/addOwner")
	public Owner addOwner(@RequestBody Owner owner) {
		return workerService.addOwner(owner);
	}

}
