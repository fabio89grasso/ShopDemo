package com.jolly.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jolly.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {
	// custom
	Optional<User> findByUsernameAndPassword(String username, String password);
}
