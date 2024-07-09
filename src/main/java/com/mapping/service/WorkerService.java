package com.mapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.entity.Owner;
import com.mapping.entity.Worker;
import com.mapping.repository.IOwnerRepository;
import com.mapping.repository.IWorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	private IWorkerRepository workerRepository;
	
	@Autowired
	private IOwnerRepository ownerRepository;
	
	public Worker addWorker(Worker worker) {		
		worker.setOwner(ownerRepository.findById(worker.getOwner().getId()).orElse(null));
		return workerRepository.save(worker);
	}
	
	public Owner addOwner(Owner owner) {
		return ownerRepository.save(owner);
	}
}
