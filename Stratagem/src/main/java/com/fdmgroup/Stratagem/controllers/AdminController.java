package com.fdmgroup.Stratagem.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.TransactionRequiredException;

import org.hibernate.id.IdentifierGenerationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.Stratagem.repository.ProjectRepository;
import com.fdmgroup.Stratagem.model.Project;



@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private ProjectRepository projectRepo;
	
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
	
	@GetMapping("/getProjects")
	public List<Project> getProjects() {
		List<Project> projects =null;
		try {
			projects = projectRepo.findAll();
			return projects;
			}
		catch (TransactionRequiredException e) {
			e.printStackTrace();
		} catch (IdentifierGenerationException e) {
			e.printStackTrace();
		} catch (JpaSystemException e) {
			e.printStackTrace();
		}

		return projects;
	}
	
}
