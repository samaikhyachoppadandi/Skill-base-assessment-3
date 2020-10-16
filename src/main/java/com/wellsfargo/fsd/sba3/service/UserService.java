package com.wellsfargo.fsd.sba3.service;

import java.util.List;


import com.wellsfargo.fsd.sba3.entity.User;
import com.wellsfargo.fsd.sba3.exception.CustomException;

public interface UserService {

	User adduser(User user) throws CustomException;
	List<User> getAllUsers() throws CustomException;
	User save(User user) throws CustomException;
	boolean delete(int userid) throws CustomException;
	User getUserById(int userid) throws CustomException;
}
