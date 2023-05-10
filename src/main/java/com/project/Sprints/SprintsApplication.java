package com.project.Sprints;



import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class SprintsApplication {

	public static void main(String[] args) {
		ApplicationContext context=  SpringApplication.run(SprintsApplication.class, args);
		
//		SprintsRepo sprintsRepo = context.getBean(SprintsRepo.class);
		
//		Sprints sprints=new Sprints();
//		sprints.setSprintId((long) 1);
//		sprints.setSprintName("run");
//		sprints.setCreatedOn(LocalDate.now());
//		sprints.setEndDate(LocalDate.now());
//		sprints.setStartDate(LocalDate.now());
//		sprints.setProjectCode((long) 123);
//		
//		Sprints spr = sprintsRepo.save(sprints);
	}

    @Bean
    ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
