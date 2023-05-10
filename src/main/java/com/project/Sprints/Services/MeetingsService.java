package com.project.Sprints.Services;

import com.project.Sprints.dto.MeetingsDTO;
import com.project.Sprints.entities.Meetings;

public interface MeetingsService {
	
	public boolean addMeetings(MeetingsDTO meetingsDTO);
	
	public MeetingsDTO showMeeting(Long meetingId);
	
	public Meetings updateMeeting(Meetings status);

}
