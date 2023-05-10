package com.project.Sprints.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Sprints.Services.MeetingPlatformsService;
import com.project.Sprints.dao.MeetingPlatformsRepo;
import com.project.Sprints.dto.MeetingPlatformsDTO;
import com.project.Sprints.entities.MeetingPlatforms;

@Service
public class MeetingPlatformsServiceImpl implements MeetingPlatformsService {

	@Autowired
	private MeetingPlatformsRepo meetingPlatformsRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<MeetingPlatformsDTO> getMeetingPlatforms() {
		// TODO Auto-generated method stub
		List<MeetingPlatforms> mp = this.meetingPlatformsRepo.findAll();
    	List<MeetingPlatformsDTO> mpDTO = mp.stream().map((mpi)->this.modelMapper.map(mpi,MeetingPlatformsDTO.class)).collect(Collectors.toList());
        return mpDTO;
	}

}
