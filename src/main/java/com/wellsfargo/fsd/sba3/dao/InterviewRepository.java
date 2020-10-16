package com.wellsfargo.fsd.sba3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.sba3.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {

	Interview findByinterviewId(int id);
	
	@Query("select i from Interview i where i.interviewerName = ?1 and i.interviewName=?2")
	List<Interview> findByDetails(String interviewerName, String  interviewName);
}
