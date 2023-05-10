package com.project.Sprints.dto;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import com.project.Sprints.entities.MeetingPlatforms;
import com.project.Sprints.entities.Sprints;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MeetingsDTO {
	private int Id;
	private String MeetingLink;
	private LocalDate MeeetingDate;
	private LocalTime MeetingTime;
	private String MeetingType;
	
	private SprintsDTO sprint;
	
	private String MeetingPassword;
	private LocalDate CreatedOn;
	
	private String Status;
	private LocalDate UpdatedOn;
	
	private MeetingPlatformsDTO mpi;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getMeetingLink() {
		return MeetingLink;
	}

	public void setMeetingLink(String meetingLink) {
		MeetingLink = meetingLink;
	}

	public LocalDate getMeeetingDate() {
		return MeeetingDate;
	}

	public void setMeeetingDate(LocalDate meeetingDate) {
		MeeetingDate = meeetingDate;
	}

	public LocalTime getMeetingTime() {
		return MeetingTime;
	}

	public void setMeetingTime(LocalTime meetingTime) {
		MeetingTime = meetingTime;
	}

	public String getMeetingType() {
		return MeetingType;
	}

	public void setMeetingType(String meetingType) {
		MeetingType = meetingType;
	}

	public SprintsDTO getSprint() {
		return sprint;
	}

	public void setSprint(SprintsDTO sprint) {
		this.sprint = sprint;
	}

	public String getMeetingPassword() {
		return MeetingPassword;
	}

	public void setMeetingPassword(String meetingPassword) {
		MeetingPassword = meetingPassword;
	}

	public LocalDate getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		CreatedOn = createdOn;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public LocalDate getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		UpdatedOn = updatedOn;
	}

	public MeetingPlatformsDTO getMpi() {
		return mpi;
	}

	public void setMpi(MeetingPlatformsDTO mpi) {
		this.mpi = mpi;
	}

	public MeetingsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeetingsDTO(int id, String meetingLink, LocalDate meeetingDate, LocalTime meetingTime, String meetingType,
			SprintsDTO sprint, String meetingPassword, LocalDate createdOn, String status, LocalDate updatedOn,
			MeetingPlatformsDTO mpi) {
		super();
		Id = id;
		MeetingLink = meetingLink;
		MeeetingDate = meeetingDate;
		MeetingTime = meetingTime;
		MeetingType = meetingType;
		this.sprint = sprint;
		MeetingPassword = meetingPassword;
		CreatedOn = createdOn;
		Status = status;
		UpdatedOn = updatedOn;
		this.mpi = mpi;
	}

	@Override
	public String toString() {
		return "MeetingsDTO [Id=" + Id + ", MeetingLink=" + MeetingLink + ", MeeetingDate=" + MeeetingDate
				+ ", MeetingTime=" + MeetingTime + ", MeetingType=" + MeetingType + ", sprint=" + sprint
				+ ", MeetingPassword=" + MeetingPassword + ", CreatedOn=" + CreatedOn + ", Status=" + Status
				+ ", UpdatedOn=" + UpdatedOn + ", mpi=" + mpi + "]";
	}
	
	
	
}
