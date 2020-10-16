package com.wellsfargo.fsd.sba3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.fsd.sba3.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByuserid(int id);
}
