package com.project.Sprints.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SprintsDTO {
	private Long  SprintId;
	private String SprintName;
	private LocalDate StartDate;
	private LocalDate EndDate;
	private Long ProjectCode;
	private LocalDate CreatedOn=LocalDate.now();
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
	public SprintsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SprintsDTO(Long sprintId, String sprintName, LocalDate startDate, LocalDate endDate, Long projectCode,
			LocalDate createdOn) {
		super();
		SprintId = sprintId;
		SprintName = sprintName;
		StartDate = startDate;
		EndDate = endDate;
		ProjectCode = projectCode;
		CreatedOn = createdOn;
	}
	@Override
	public String toString() {
		return "SprintsDTO [SprintId=" + SprintId + ", SprintName=" + SprintName + ", StartDate=" + StartDate
				+ ", EndDate=" + EndDate + ", ProjectCode=" + ProjectCode + ", CreatedOn=" + CreatedOn + "]";
	}
	
	
}
