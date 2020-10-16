package com.wellsfargo.fsd.sba3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.sba3.dao.InterviewRepository;
import com.wellsfargo.fsd.sba3.entity.Interview;
import com.wellsfargo.fsd.sba3.exception.CustomException;

@Service
public class InterviewServiceImpl implements InterviewService {

@Autowired
private InterviewRepository intRepo;
	@Override
	@Transactional
	public Interview addInterview(Interview interview) throws CustomException {
		// TODO Auto-generated method stub
		if(interview!=null) {
			if(intRepo.existsById(interview.getInterviewId())) {
				throw new CustomException("Interview code already used!");
			}
			
			intRepo.save(interview);
		}
		return interview;
		
	}

	@Override
	@Transactional
	public Interview update(Interview interview) throws CustomException {
		if(interview!=null) {
			if(!intRepo.existsById(interview.getInterviewId())) {
				throw new CustomException("Intereview id Not Found");
			}
			
			intRepo.save(interview);
		}
		return interview;
		
	}

	@Override
	@Transactional
	public boolean deleteInterview(int interviewid) throws CustomException {
		// TODO Auto-generated method stub
		if(!intRepo.existsById(interviewid)) {
			throw new CustomException("Interview details Not Found");
		}
	
		intRepo.deleteById(interviewid);
		return true;
	}
	@Override
	@Transactional
	public List<Interview> getAllInterviewList() throws CustomException {
		return intRepo.findAll();
	}

	@Override
	public List<Interview> getListByName(String interviewName, String interviewerName) throws CustomException {
		return intRepo.findByDetails(interviewerName, interviewName);
		
	}

	@Override
	public Interview getInterviewById(int interviewId) throws CustomException {
		// TODO Auto-generated method stub
		return intRepo.findById(interviewId).orElse(null);
	}

	

}
