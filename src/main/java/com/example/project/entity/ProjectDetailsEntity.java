package com.example.project.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_DETAILS")
@IdClass(ProjectId.class)
public class ProjectDetailsEntity {
	
	@Id
	@Column(name = "PROJECT_NAME", nullable=false)
	private String projectName;
	
	@Column(name = "REASON", nullable = false)
	private String reason;
	
	@Column(name = "TYPE", nullable = false)
	private String type;
	
	@Column(name = "DIVISION", nullable = false)
	private String division;
	
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	
	@Column(name = "PRIORITY", nullable = false)
	private String priority;
	
	@Column(name = "DEPARTMEMT", nullable = false)
	private String department;
	
	@Id
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;
	
	@Column(name = "END_DATE", nullable = false)
	private Date endDate;
	
	@Column(name = "LOCATION", nullable = false)
	private String location;
	
	@Column(name = "STATUS", nullable = false)
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
