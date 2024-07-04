package com.example.project.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class ProjectId implements Serializable {

    private String projectName;
    private Date startDate;

 
    public ProjectId() {}

    public ProjectId(String projectName, Date startDate) {
        this.projectName = projectName;
        this.startDate = startDate;
    }

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectId projectId = (ProjectId) o;
        return projectName.equals(projectId.projectName) && startDate.equals(projectId.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, startDate);
    }
}
