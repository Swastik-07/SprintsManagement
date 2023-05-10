package com.project.Sprints.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import org.hibernate.annotations.Check;

@Entity
public class Sprints {
	@Id
	private Long  SprintId;
	private String SprintName;
	
    @Column(name = "start_date", nullable = false)
	private LocalDate StartDate;
	
    @Column(name = "end_date", nullable = false)
    @Check(constraints = "end_date > start_date")
	private LocalDate EndDate;
	private Long ProjectCode;
	private LocalDate CreatedOn=LocalDate.now();
	
	@OneToMany(mappedBy="sprint", cascade=CascadeType.ALL)
	private List<Meetings> meetings=new ArrayList<>(); 
	
	public Long getSprintId() {
		return SprintId;
	}
	public void setSprintId(Long sprintId) {
		SprintId = sprintId;
	}
	public String getSprintName() {
		return SprintName;
	}
	public void setSprintName(String sprintName) {
		SprintName = sprintName;
	}
	public LocalDate getStartDate() {
		return StartDate;
	}
	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}
	public LocalDate getEndDate() {
		return EndDate;
	}
	public void setEndDate(LocalDate endDate) {
		EndDate = endDate;
	}
	public Long getProjectCode() {
		return ProjectCode;
	}
	public void setProjectCode(Long projectCode) {
		ProjectCode = projectCode;
	}
	public LocalDate getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		CreatedOn = createdOn;
	}
	public Sprints(Long sprintId, String sprintName, LocalDate startDate, LocalDate endDate, Long projectCode) {
		super();
		SprintId = sprintId;
		SprintName = sprintName;
		StartDate = startDate;
		EndDate = endDate;
		ProjectCode = projectCode;
		
	}
	public Sprints() {
		super();
	}
	@Override
	public String toString() {
		return "Sprints [SprintId=" + SprintId + ", SprintName=" + SprintName + ", StartDate=" + StartDate
				+ ", EndDate=" + EndDate + ", ProjectCode=" + ProjectCode + ", CreatedOn=" + CreatedOn + "]";
	}
	
	
}
