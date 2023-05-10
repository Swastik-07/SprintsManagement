package com.project.Sprints.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Sprints.ServicesImpl.MeetingPlatformsServiceImpl;
import com.project.Sprints.dto.MeetingPlatformsDTO;

@RestController
public class MeetingPlatformsController {
	
	@Autowired
	public MeetingPlatformsServiceImpl meetingPlatformsServiceImpl;

	
	@GetMapping("/api/meetings/platforms")
	public List<MeetingPlatformsDTO> getMeetingPlatforms(){
		return this.meetingPlatformsServiceImpl.getMeetingPlatforms();
	}
}
