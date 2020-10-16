package com.wellsfargo.fsd.sba3.entity;

import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Interview")
public class Interview {
//interviewId, interviewerName, interviewName, userSkills, time, date, interviewStatus,remarks
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int interviewId;
	
	@Column
	@NotNull(message = "interviewer name cannot be null")
	@NotBlank(message = "interviewer name cannot be blank")
	@Size(min = 5,max=30,message = "interviewer name must be of 5 to 30 chars in length")
	private String interviewerName;
	

	@Column
	@NotNull(message = "interview name cannot be null")
	@NotBlank(message = "interview name cannot be blank")
	@Size(min = 3,max=30,message = "interview name must be of 3 to 30 chars in length")
	private String interviewName;
	
	@Column
	@NotNull(message = "userskills  cannot be null")
	@NotBlank(message = "userskills cannot be blank")
	@Size(min = 5,max=30,message = "userskills name must be of 5 to 30 chars in length")
	private String userSkills;
	
	@Column
	private String time;
	
	@Column
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull(message = "Date can not be omitted")
	@PastOrPresent(message = " date can not be a future date")
	private LocalDate date;
	
	@Column
	@NotNull(message = "status cannot be null")
	@NotBlank(message = "status cannot be blank")
	@Size(min = 5,max=30,message = "status must be of 5 to 30 chars in length")
	private String interviewStatus;
	
	@Column
	@NotNull(message = "remarks cannot be null")
	@NotBlank(message = "remarks cannot be blank")
	@Size(min = 5,max=30,message = "remarks must be of 5 to 30 chars in length")
	private String remarks;
	
	@ManyToMany(mappedBy = "interviews", cascade = { CascadeType.ALL })
	private Set<User> users = new HashSet<User>();
	    
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public int getInterviewId() {
		return interviewId;
	}
	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getInterviewName() {
		return interviewName;
	}
	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}
	public String getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(String userSkills) {
		this.userSkills = userSkills;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
