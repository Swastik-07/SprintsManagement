package com.project.Sprints.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MeetingPlatforms {
	@Id
	private long Id;
	private String Name;
	
	@OneToMany(mappedBy="mpi", cascade = CascadeType.ALL)
	private List<Meetings> meetings=new ArrayList<>();
	
	
	public MeetingPlatforms() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public MeetingPlatforms(int id, String name) {
		super();
		Id = id;
		Name = name;
	}
	@Override
	public String toString() {
		return "MeetingPlatforms [Id=" + Id + ", Name=" + Name + "]";
	}
	
	
}
