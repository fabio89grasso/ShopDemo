package com.jolly.service;

import java.util.Optional;

import com.jolly.model.User;

public interface IUserService {
	User saveUser(User user);
	// custom
	Optional<User> checkCredential(String username, String password);
}
