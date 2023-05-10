package com.project.Sprints.Services;

import java.util.List;

import com.project.Sprints.dto.SprintsDTO;

public interface SprintsService {
	public List<SprintsDTO> getSprints();
	
	public boolean addSprint(SprintsDTO sprintDTO);
}
