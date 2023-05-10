package com.project.Sprints.ServicesImpl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Sprints.Services.SprintsService;
import com.project.Sprints.dao.SprintsRepo;
import com.project.Sprints.dto.SprintsDTO;
import com.project.Sprints.entities.Sprints;

@Service
public class SprintsServiceImpl implements SprintsService {
	@Autowired
	private SprintsRepo sprintsRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<SprintsDTO> getSprints() {
		// TODO Auto-generated method stub
		List<Sprints> spr = this.sprintsRepo.findAll();
		List<SprintsDTO> sprDTO = spr.stream().map((spri) -> this.modelMapper.map(spri, SprintsDTO.class))
				.collect(Collectors.toList());
		return sprDTO;
	}

	@Override
	public boolean addSprint(SprintsDTO sprintDTO) {

		Sprints sprint = this.modelMapper.map(sprintDTO, Sprints.class);

		if (!sprintDurationValidator(sprintDTO)) {
			return false;
		}

		Optional<Sprints> checkSprint = sprintsRepo.findById(sprintDTO.getSprintId());

		if (checkSprint.isPresent()) {
			return false;
		}
		
		sprintsRepo.save(sprint);
		return true;
	}

	public boolean sprintDurationValidator(SprintsDTO sprintsDTO) {

		LocalDate start = sprintsDTO.getStartDate();
		LocalDate end = sprintsDTO.getEndDate();

		long numWeeks = ChronoUnit.WEEKS.between(start, end);

		if (numWeeks < 1 || numWeeks > 4) {
			return false;
		}

		return true;
	}

	public void sprintNameGeneration(Sprints sprintsDTO) {
		long sprintNum = sprintsDTO.getSprintId();
		String sprintName = String.format("Sprint-%10d", sprintNum);
		sprintsDTO.setSprintName(sprintName);
	}

}
