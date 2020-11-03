package com.fdmgroup.Stratagem.controllers;

import java.util.List;
import javax.persistence.TransactionRequiredException;

import org.hibernate.id.IdentifierGenerationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.fdmgroup.Stratagem.model.Project;
import com.fdmgroup.Stratagem.model.User;
import com.fdmgroup.Stratagem.repository.ProjectRepository;
import com.fdmgroup.Stratagem.repository.UserRepository;


@RestController
@CrossOrigin("*")
public class AdminController {

    @Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private UserRepository userRepo;
	
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
	
	@PostMapping("/createProject")
	public boolean createProject(@RequestBody Project project) {
		System.out.println(project.toString());
		try {
			projectRepo.save(project);
			return true;
			}
		catch (TransactionRequiredException e) {
			e.printStackTrace();
		} catch (IdentifierGenerationException e) {
			e.printStackTrace();
		} catch (JpaSystemException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@PostMapping("/deleteProject")
	public boolean deleteProject(@RequestBody Project project) {
		System.out.println(project.toString());
		try {
			projectRepo.delete(project);
			return true;
			}
		catch (TransactionRequiredException e) {
			e.printStackTrace();
		} catch (IdentifierGenerationException e) {
			e.printStackTrace();
		} catch (JpaSystemException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@PostMapping("/addNewUser")
	public boolean addNewUser(@RequestBody User user) {
		if (user.getFirstName().trim().isEmpty() || user.getLastName().trim().isEmpty()
			|| user.getPassword().trim().isEmpty()) {
			return false;
		} else if (userRepo.existsById(user.getEmail())) {
			return false;
		} else {
			userRepo.save(user);
			return true;
		}
	}
	
	@PostMapping("/removeUser")
	public boolean removeUser(@RequestBody User user) {
		if (!userRepo.existsById(user.getEmail())) {
			return false;
		} else {
			userRepo.delete(user);
			return true;
		}
	}
}
