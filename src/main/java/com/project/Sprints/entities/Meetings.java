package com.project.Sprints.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

@Entity
public class Meetings {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	private String MeetingLink;
	private LocalDate MeeetingDate;
	private LocalTime MeetingTime;
	@Pattern(regexp = "DailyScrum|SprintPlanning|SprintReview|SprintRetrospective")
	private String MeetingType;
	
	@ManyToOne
	@JoinColumn(name="sprint_id")
	private Sprints sprint;
	
	private String MeetingPassword;
	private LocalDate CreatedOn;
	
	@Pattern(regexp = "scheduled|completed|cancelled|rescheduled")
	private String Status;
	private LocalDate UpdatedOn;
	
	@ManyToOne
	@JoinColumn(name="meeting_platform_id") 
	private MeetingPlatforms mpi;

	public long getId() {
		return Id;
	}

	public void setId(Long id) {
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

	public Sprints getSprint() {
		return sprint;
	}

	public void setSprint(Sprints sprint) {
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

	public MeetingPlatforms getMpi() {
		return mpi;
	}

	public void setMpi(MeetingPlatforms mpi) {
		this.mpi = mpi;
	}

	public Meetings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meetings(int id, String meetingLink, LocalDate meeetingDate, LocalTime meetingTime, String meetingType,
			Sprints sprint, String meetingPassword, LocalDate createdOn, String status, LocalDate updatedOn,
			MeetingPlatforms mpi) {
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
		return "Meetings [Id=" + Id + ", MeetingLink=" + MeetingLink + ", MeeetingDate=" + MeeetingDate
				+ ", MeetingTime=" + MeetingTime + ", MeetingType=" + MeetingType + ", Sprint=" + sprint
				+ ", MeetingPassword=" + MeetingPassword + ", CreatedOn=" + CreatedOn + ", Status=" + Status
				+ ", UpdatedOn=" + UpdatedOn + "]";
	}
	
	
	
}
