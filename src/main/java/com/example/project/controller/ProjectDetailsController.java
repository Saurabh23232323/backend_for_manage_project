package com.example.project.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entity.ProjectDetailsEntity;
import com.example.project.entity.ProjectId;
import com.example.project.service.ProjectDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ProjectDetailsController {
	@Autowired
	ProjectDetailsService service;
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	int i = 0;
	
	@GetMapping(value = "/save/{projectName}/{reason}/{type}/{division}/{category}/{priority}/{department}/{startDate}/{endDate}/{location}")
	boolean verify(@PathVariable("projectName") String projectName, 
			@PathVariable("reason") String reason,
			@PathVariable("type") String type,
			@PathVariable("division") String division,
			@PathVariable("category") String category,
			@PathVariable("priority") String priority,
			@PathVariable("department") String department,
			@PathVariable("startDate") Date startDate,
			@PathVariable("endDate") Date endDate,
			@PathVariable("location") String location) {
		
		i =  ID_GENERATOR.getAndIncrement();
		
		ProjectDetailsEntity entity = new ProjectDetailsEntity();
		entity.setProjectName(projectName);
		entity.setReason(reason);
		entity.setType(type);
		entity.setDivision(division);
		entity.setCategory(category);
		entity.setPriority(priority);
		entity.setDepartment(department);
		entity.setStartDate(startDate);
		entity.setEndDate(endDate);
		entity.setLocation(location);
		entity.setStatus("Registered");
		return service.saveProjectDetails(entity);
	}
	
	@GetMapping("/List")
	public List<ProjectDetailsEntity> getNinjacarsById(){
		return service.getProjectList();
	}

	
	 @GetMapping("/counters")
	    public Map<String, Long> getCounters() {
	        Map<String, Long> counters = new HashMap<>();
	        counters.put("totalProjects", service.getTotalProjects());
	        counters.put("closedProjects", service.getClosedProjects());
	        counters.put("runningProjects", service.getRunningProjects());
	        counters.put("closureDelayProjects", service.getClosureDelayProjects(new Date(System.currentTimeMillis())));
	        counters.put("cancelledProjects", service.getCancelledProjects());
	        return counters;
	    }
	 
	 @PostMapping("/update-status")
	    public ProjectDetailsEntity updateProjectStatus(@RequestParam String projectName, @RequestParam String startDate, @RequestParam String status) {
	        ProjectId projectId = new ProjectId(projectName, Date.valueOf(startDate));
	        return service.updateProjectStatus(projectId, status);
	    }
}
