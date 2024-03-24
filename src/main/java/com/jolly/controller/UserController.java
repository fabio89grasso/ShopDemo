package com.jolly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jolly.model.User;
import com.jolly.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/signIn")
	public String signIn(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "sign_in";
	}
	
	@PostMapping("/user/new")
	public String addUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "user";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/user")
	public String goUserPage(@ModelAttribute("user") User user, Model model) {
		Optional<User> findUser = userService.checkCredential(user.getUsername(), user.getPassword());
		if(findUser.isEmpty() == false) {
			if(user.getUsername().equals("admin")) {
				return "redirect:/admin";
			}
			model.addAttribute("user", user);
			return "user";
		}else {
			return "redirect:/login";
		}
	}

}
