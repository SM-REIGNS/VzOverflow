package com.verizon.lambda.service;

import java.awt.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.lambda.dao.UserRepository;
import com.verizon.lambda.entities.User;
import com.verizon.lambda.exceptions.EmployeeNotFoundException;
@Service
public class UserServiceImpl implements UserService {
	
	
	private UserRepository userRepository;
	
	
	public UserRepository getUserRepository() {
		return userRepository;
	}
	
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public User findUserById(String Id) {
		Optional<User> response =  userRepository.findById(Id);
		
		if (!response.isPresent())
		{
			throw new EmployeeNotFoundException("user not found with the given id");
		}
				
		User user = response.get();
		return user;
	}

	

}
