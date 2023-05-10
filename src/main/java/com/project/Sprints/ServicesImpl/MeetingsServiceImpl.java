package com.project.Sprints.ServicesImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Sprints.Services.MeetingsService;
import com.project.Sprints.dao.MeetingsRepo;
import com.project.Sprints.dto.MeetingsDTO;
import com.project.Sprints.entities.Meetings;
import com.project.Sprints.exception.MeetingStatusUpdateFailedException;

@Service
public class MeetingsServiceImpl implements MeetingsService {

	@Autowired
	private MeetingsRepo meetingsRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public boolean addMeetings(MeetingsDTO meetingsDTO) {
		// TODO Auto-generated method stub
		Meetings meetings2 = this.modelMapper.map(meetingsDTO, Meetings.class);

		Optional<Meetings> checkMeetings = meetingsRepo.findById((long) meetingsDTO.getId());

		if (checkMeetings.isPresent()) {
			return false;
		}

		if (meetings2.getMeetingType().equalsIgnoreCase("DailyScrum")) {
			this.createDailyScrumMeetings(meetings2);
		} 
		else if(meetings2.getMeetingType().equalsIgnoreCase("SprintPlanning")) {
			meetings2.setMeeetingDate(meetings2.getSprint().getStartDate());
			meetingsRepo.save(meetings2);
		}
		else if(meetings2.getMeetingType().equalsIgnoreCase("SprintReview") || meetings2.getMeetingType().equalsIgnoreCase("SprintRestrospective")) {
			meetings2.setMeeetingDate(meetings2.getSprint().getEndDate());
			meetingsRepo.save(meetings2);
		}
		else {
			meetingsRepo.save(meetings2);
		}
		return true;
	}

	@Override
	public MeetingsDTO showMeeting(Long meetingId) {
		// TODO Auto-generated method stub

		Optional<Meetings> chk = meetingsRepo.findById(meetingId);
		if (chk.isPresent()) {
			MeetingsDTO meetingDTO = this.modelMapper.map(chk.get(), MeetingsDTO.class);
			return meetingDTO;
		}
		return null;
	}

	@Override
	public Meetings updateMeeting(Meetings status) throws MeetingStatusUpdateFailedException {
		// TODO Auto-generated method stub
		Optional<Meetings> meetings = meetingsRepo.findById(status.getId());
		
		
		if (meetings.isPresent()) {
			
			if(meetings.get().getStatus().equalsIgnoreCase("Completed")) {
				throw new MeetingStatusUpdateFailedException("Update Cannot be done for completed meetings");
			}
			
			meetingsRepo.save(status);
		}
		return status;
	}

	public void createDailyScrumMeetings(Meetings meeting) {

		LocalDate scrumDate = meeting.getCreatedOn();
		Long meetingId = meeting.getId();
		int count = 0;
		do {
			//System.out.println("----here-----");
			Meetings scrumMeeting = new Meetings();
			scrumDate=scrumDate.plusDays(1);
			count += 1;
			scrumMeeting.setMeetingLink(meeting.getMeetingLink());
			scrumMeeting.setMeeetingDate(scrumDate);
			LocalTime meetingTime = LocalTime.of(0, 15);
			scrumMeeting.setMeetingTime(meetingTime);
			scrumMeeting.setMeetingType(meeting.getMeetingType());
			scrumMeeting.setSprint(meeting.getSprint());
			scrumMeeting.setMeetingPassword(meeting.getMeetingPassword());
			scrumMeeting.setCreatedOn(meeting.getCreatedOn());
			scrumMeeting.setStatus(meeting.getStatus());
			scrumMeeting.setMpi(meeting.getMpi());
			scrumMeeting.setUpdatedOn(meeting.getUpdatedOn());
			Meetings save = meetingsRepo.save(scrumMeeting);
			

			System.out.println(save.toString()+"\n"+count);
			
		} while (scrumDate.isBefore(meeting.getSprint().getEndDate()));
	}
	
	public void meetingDateUpdation(Meetings meetings) {
		
		
		meetingsRepo.save(meetings);
	}

}
