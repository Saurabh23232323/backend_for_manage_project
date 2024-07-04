package com.example.project.entity.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.project.entity.LoginEntity;
import com.example.project.entity.ProjectDetailsEntity;
import com.example.project.entity.ProjectId;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetailsEntity, ProjectId> {
	
	   long countByStatus(String status);
	   long countByStatusAndEndDateBefore(String status, Date endDate);
}
