package com.wellsfargo.fsd.sba3.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
public class User implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//userId, firstName, lastName, email, status
	
	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	
	@Column(name = "firstname")
	@NotNull(message = "first name cannot be null")
	@NotBlank(message = "first name cannot be blank")
	@Size(min = 5,max=30,message = "first name must be of 5 to 30 chars in length")
	private String firstname;
	
	@Column(name="lastname")
	@NotNull(message = "last name cannot be null")
	@NotBlank(message = "last name cannot be blank")
	@Size(min = 3,max=25,message = "last name must be of 3 to 25 chars in length")
	private String lastname;
	
	@Column(name = "email")
	@Email
	private String email;
	
	@Column(name="status")
	private String status;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "user_interview",
		        joinColumns = {@JoinColumn(name = "userid") },
		        inverseJoinColumns = {@JoinColumn(name = "interviewId") })
	private Set<Interview> interviews = new HashSet <Interview>();
	 
	public Set<Interview> getInterviews() {
		return interviews;
	}
	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}
	public User() {
		
		// TODO Auto-generated constructor stub
	}
	public User(int userid,
			@NotNull(message = "first name cannot be null") @NotBlank(message = "first name cannot be blank") @Size(min = 5, max = 30, message = "first name must be of 5 to 30 chars in length") String firstname,
			@NotNull(message = "last name cannot be null") @NotBlank(message = "last name cannot be blank") @Size(min = 5, max = 25, message = "last name must be of 5 to 25 chars in length") String lastname,
			@Email String email, String status) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.status = status;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}