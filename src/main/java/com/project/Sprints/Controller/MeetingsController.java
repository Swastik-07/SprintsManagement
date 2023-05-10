package com.project.Sprints.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Sprints.Services.MeetingsService;
import com.project.Sprints.dto.MeetingsDTO;
import com.project.Sprints.entities.Meetings;

@RestController
public class MeetingsController {
	
	@Autowired
	public MeetingsService meetingsService;
	
	@PostMapping("/api/meetings/new")
	public ResponseEntity<Void> addMeetings(@RequestBody MeetingsDTO meetings) {
		boolean checkMeetings=meetingsService.addMeetings(meetings);
		if(checkMeetings) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
        else
			return ResponseEntity.internalServerError().build();
		
	}
	
	@GetMapping("/api/meetings/{meetingId}")
	public MeetingsDTO showMeeting(@PathVariable String meetingId) {
		return this.meetingsService.showMeeting(Long.parseLong(meetingId));
	}
	
	@PutMapping("/api/meetings/{meetingId}/reschedule")
	public Meetings updateMeeting(@PathVariable Long meetingId, @RequestBody Meetings status) {
		return this.meetingsService.updateMeeting(status);
	}
}
