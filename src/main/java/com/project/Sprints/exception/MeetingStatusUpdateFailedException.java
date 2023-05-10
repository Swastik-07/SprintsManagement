package com.project.Sprints.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class MeetingStatusUpdateFailedException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public MeetingStatusUpdateFailedException(String message) {
		super(message);
		
	}
}
