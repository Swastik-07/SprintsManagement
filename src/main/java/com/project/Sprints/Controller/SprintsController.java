package com.project.Sprints.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Sprints.Services.SprintsService;
import com.project.Sprints.dto.SprintsDTO;

@RestController
@RequestMapping("/api/sprints")
public class SprintsController {
	@Autowired
	public SprintsService sprintService;
	
	@GetMapping
	public List<SprintsDTO> getSprints(){
		return this.sprintService.getSprints();
	}
	
	
	@PostMapping("/new")
	public ResponseEntity<String> addSprint(@RequestBody SprintsDTO sprint) {
		boolean checkSprint=sprintService.addSprint(sprint);
		if(checkSprint) {
        return ResponseEntity.ok(sprint.getSprintName());
		}
		else 
			return ResponseEntity.internalServerError().build();
	}
	
}
