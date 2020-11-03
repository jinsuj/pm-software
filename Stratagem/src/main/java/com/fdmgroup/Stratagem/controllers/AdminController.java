package com.fdmgroup.Stratagem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.Stratagem.model.User;
import com.fdmgroup.Stratagem.repositories.UserRepository;

@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("list-users")
	public List<User> listUsers() {
		List<User> userList = userRepo.findAll();
		return userList;
	}
	
	@PostMapping("update-user")
	public void updateUser(@RequestBody User userToChange) {
		User user = userRepo.getOne(userToChange.getEmail());
		user = userToChange;
	}
	
	@PostMapping("update-user-role")
	public void updateUserRole(@RequestBody User userToChange) {
		User user = userRepo.getOne(userToChange.getEmail());
		user.setRole(userToChange.getRole());
	}
	
}
