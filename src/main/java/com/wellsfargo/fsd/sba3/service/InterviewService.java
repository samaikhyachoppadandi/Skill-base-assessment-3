package com.wellsfargo.fsd.sba3.service;

import java.util.List;


import com.wellsfargo.fsd.sba3.entity.Interview;

import com.wellsfargo.fsd.sba3.exception.CustomException;


public interface InterviewService {

	Interview addInterview(Interview interview) throws CustomException;
	 
	Interview update(Interview interview) throws CustomException;

	boolean deleteInterview(int interviewid) throws CustomException;

	List<Interview> getListByName(String interviewName, String interviewerName) throws CustomException;

	List<Interview> getAllInterviewList() throws CustomException;
	
	Interview getInterviewById(int interviewId) throws CustomException;
}
