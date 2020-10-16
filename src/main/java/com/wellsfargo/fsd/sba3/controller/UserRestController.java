package com.wellsfargo.fsd.sba3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.fsd.sba3.entity.User;
import com.wellsfargo.fsd.sba3.exception.CustomException;
import com.wellsfargo.fsd.sba3.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user1) throws CustomException{
		
		return new ResponseEntity<User>(userService.adduser(user1),HttpStatus.OK);
	}	
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() throws CustomException{
		
			return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
		}
	
	@GetMapping("/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable("userid") int userid) throws CustomException{
	
		ResponseEntity<User> response = null;
		User u = userService.getUserById(userid);
		
		
		if(u!=null)
		{
			response = new ResponseEntity<User>(u, HttpStatus.OK);
		}
		else
		{
			response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userid") int userid) throws CustomException{
		ResponseEntity<Void> response=null;
		
		boolean isDeleted = userService.delete(userid);
		
		if(isDeleted) {		
			response =new ResponseEntity<>(HttpStatus.OK); 
		}else {
			response =new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
}
