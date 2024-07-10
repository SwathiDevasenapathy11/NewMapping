package com.mapping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mapping.dto.EmployeeRecDto;
import com.mapping.dto.ProjectDto;
import com.mapping.entity.EmployeeRec;
import com.mapping.entity.Project;
import com.mapping.repository.IEmployeeRecRespository;
import com.mapping.repository.IProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private IEmployeeRecRespository employeeRecRepository;
	
	@Autowired
	private IProjectRepository projectRepository;
	
	public EmployeeRec addEmployee(EmployeeRec employee) {
		return employeeRecRepository.save(employee);
	}
	
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}
	
	public ResponseEntity<String> addEmployeeWithProject(Long employeeId , Long projectId ) {
        Project project = projectRepository.findById(projectId).get();	
        EmployeeRec employee = employeeRecRepository.findById(employeeId).get();
        
        if(employee.getProject().contains(project)) {
        	return ResponseEntity.badRequest().body("Already data is there");
        }
        
        employee.getProject().add(project);
        project.getEmployee().add(employee);
        
        employeeRecRepository.save(employee);
        projectRepository.save(project);
        
        return ResponseEntity.ok().body("ADDED SUCCESSFULLY"); 
	}
	
	public List<EmployeeRecDto> getAllEmployee(){
		List<EmployeeRecDto> employeeDetails = new ArrayList<>();
		List<EmployeeRec> getEmployeeDetails = employeeRecRepository.findAll();
		
		for(EmployeeRec employees : getEmployeeDetails) {
			EmployeeRecDto dto = new EmployeeRecDto();
			dto.setId(employees.getId());
			dto.setName(employees.getName());
			dto.setRole(employees.getRole());
			List<ProjectDto> projectDto = new ArrayList<>();
			for(Project project : employees.getProject()) {
				ProjectDto projectDtoo = new ProjectDto();
				projectDtoo.setId(project.getId());
				projectDtoo.setName(project.getName());
				projectDtoo.setClient(project.getClient());
				projectDto.add(projectDtoo);
			}
			dto.getProjects().addAll(projectDto);
			employeeDetails.add(dto);
		}
		
		return employeeDetails;
	}
	
	public List<Project> getAllProject(){
		return projectRepository.findAll();
	}
}
