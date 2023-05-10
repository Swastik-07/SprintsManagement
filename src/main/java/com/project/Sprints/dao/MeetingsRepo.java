package com.project.Sprints.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Sprints.entities.Meetings;

public interface MeetingsRepo extends JpaRepository<Meetings, Long>{

}
