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

import com.mapping.dto.EmployeeRecDto;
import com.mapping.entity.EmployeeRec;
import com.mapping.entity.Project;
import com.mapping.service.ProjectService;

@RestController
@RequestMapping("/recursive")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/addEmployee")
	public EmployeeRec addEmployee(@RequestBody EmployeeRec employeeRec) {
		return projectService.addEmployee(employeeRec);
	}

	@PostMapping("/addProject")
	public Project addProject(@RequestBody Project project) {
		return projectService.addProject(project);
	}
	
	@PostMapping("/{employeeId}/addEmployeeWithProject/{projectId}")
	public ResponseEntity<String> employeeWithProject(@PathVariable Long employeeId ,@PathVariable Long projectId){
		 return projectService.addEmployeeWithProject(employeeId , projectId);
	}
	
	@GetMapping("/getEmployees")
	public List<EmployeeRecDto> getEmployee(){
		return projectService.getAllEmployee();
	}
	
	@GetMapping("/getProjects")
	public List<Project> getProject(){
		return projectService.getAllProject();
	}
}
