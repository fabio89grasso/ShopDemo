package com.jolly.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jolly.model.User;
import com.jolly.repository.IUserRepository;
import com.jolly.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> checkCredential(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
	
}
