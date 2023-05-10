package com.project.Sprints.dto;


public class MeetingPlatformsDTO {
	private long Id;
	private String Name;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public MeetingPlatformsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeetingPlatformsDTO(long id, String name) {
		super();
		Id = id;
		Name = name;
	}
	@Override
	public String toString() {
		return "MeetingPlatformsDTO [Id=" + Id + ", Name=" + Name + "]";
	}
	
	
	
	
	
}
