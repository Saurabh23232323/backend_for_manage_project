package com.example.project.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.entity.ProjectDetailsEntity;
import com.example.project.entity.ProjectId;
import com.example.project.entity.repository.ProjectDetailsRepository;

@Component
public class ProjectDetailsService {
	
	@Autowired
	ProjectDetailsRepository projectRepository;
	
	public boolean saveProjectDetails(ProjectDetailsEntity entity) {
		projectRepository.save(entity);
		return true;
	}
	
	public List<ProjectDetailsEntity> getProjectList(){
		return projectRepository.findAll();
	}
	
	public void setStatus(String status, String projectName) {
		projectRepository.findAll();
	}
	
	public long getTotalProjects() {
        return projectRepository.count();
    }

    public long getClosedProjects() {
        return projectRepository.countByStatus("Closed");
    }

    public long getRunningProjects() {
        return projectRepository.countByStatus("Running");
    }

    public long getClosureDelayProjects(Date currentDate) {
        return projectRepository.countByStatusAndEndDateBefore("Running", currentDate);
    }

    public long getCancelledProjects() {
        return projectRepository.countByStatus("Cancelled");
    }
    
    
    public ProjectDetailsEntity updateProjectStatus(ProjectId projectId, String status) {
        Optional<ProjectDetailsEntity> projectOpt = projectRepository.findById(projectId);
        if (projectOpt.isPresent()) {
            ProjectDetailsEntity project = projectOpt.get();
            project.setStatus(status);
            return projectRepository.save(project);
        }
        return null;
    }

}
