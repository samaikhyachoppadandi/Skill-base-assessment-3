package com.wellsfargo.fsd.sba3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.sba3.dao.UserRepository;

import com.wellsfargo.fsd.sba3.entity.User;
import com.wellsfargo.fsd.sba3.exception.CustomException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository UserRepo;
	
	
	@Override
	@Transactional
	public User adduser(User user) throws CustomException {
		// TODO Auto-generated method stub
		
		if(user!=null)
		{
			if(UserRepo.existsById(user.getUserid())) {
			throw new CustomException("user id already used!");
		}
		
		UserRepo.save(user);
}
	return user;
	}
	@Override
	public List<User> getAllUsers() throws CustomException {
		// TODO Auto-generated method stub
		return UserRepo.findAll();
	}
	
	@Override
	@Transactional
	public User save(User item) throws CustomException {
		if(item!=null) {
			if(!UserRepo.existsById(item.getUserid())) {
				throw new CustomException("Item Not Found");
			}
			
		UserRepo.save(item);
		}
		return item;
	}
	@Override
	public boolean delete(int userid) throws CustomException {
		// TODO Auto-generated method stub
		if(!UserRepo.existsById(userid)) {
			throw new CustomException("Item Not Found");
		}
	
		UserRepo.deleteById(userid);
		return true;
	
	}
	@Override
	public User getUserById(int userid) throws CustomException {
		return UserRepo.findById(userid).orElse(null);
	}

}
