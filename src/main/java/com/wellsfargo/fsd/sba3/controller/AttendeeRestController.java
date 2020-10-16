package com.wellsfargo.fsd.sba3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.sba3.entity.Interview;
import com.wellsfargo.fsd.sba3.entity.User;
import com.wellsfargo.fsd.sba3.exception.CustomException;
import com.wellsfargo.fsd.sba3.service.InterviewService;
import com.wellsfargo.fsd.sba3.service.UserService;

@RestController
@RequestMapping("/attendee")
public class AttendeeRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private InterviewService intService;

	@PostMapping("/{userid}/{interviewid}")
	public ResponseEntity<User> addAttendee(@PathVariable("userid") int userid ,@PathVariable("interviewid") int interviewid)throws CustomException
	{
		User u  =userService.getUserById(userid);
		Interview i = intService.getInterviewById(interviewid);
		u.getInterviews().add(i);
		i.getUsers().add(u);
		return new ResponseEntity<User>(userService.save(u),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> Listallattendee() throws CustomException{
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	}
	
	