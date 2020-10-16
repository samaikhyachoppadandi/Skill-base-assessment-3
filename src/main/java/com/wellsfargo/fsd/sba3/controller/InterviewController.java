package com.wellsfargo.fsd.sba3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.sba3.entity.Interview;

import com.wellsfargo.fsd.sba3.exception.CustomException;
import com.wellsfargo.fsd.sba3.service.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewController {
	
	@Autowired
	private InterviewService intService;
	
	@GetMapping
	public ResponseEntity<List<Interview>> getAllInterview() throws CustomException{
		return new ResponseEntity<List<Interview>>(intService.getAllInterviewList(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Interview> addInterview(@RequestBody Interview interview ) throws CustomException{
		return new ResponseEntity<Interview>(intService.addInterview(interview),HttpStatus.OK);
	}
	
	@DeleteMapping("/{interviewid}")
	public ResponseEntity<Void> deleteInterview(@PathVariable("interviewid") int interviewid) throws CustomException{
		ResponseEntity<Void> response=null;
		
		boolean isDeleted = intService.deleteInterview(interviewid);
		
		if(isDeleted) {		
			response =new ResponseEntity<>(HttpStatus.OK); 
		}else {
			response =new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	@PutMapping
	public ResponseEntity<Interview> updateItem(@RequestBody Interview interview) throws CustomException{
		return new ResponseEntity<Interview>(intService.update(interview),HttpStatus.OK);
	}
	
	@GetMapping("/{interviewerName}/{interviewName}")
	public ResponseEntity<List<Interview>> getInterview(@PathVariable("interviewerName") String interviewerName, @PathVariable("interviewName") String interviewName ) throws CustomException{
		return new ResponseEntity<List<Interview>>(intService.getListByName(interviewName,interviewerName), HttpStatus.OK);
	}
	
}
