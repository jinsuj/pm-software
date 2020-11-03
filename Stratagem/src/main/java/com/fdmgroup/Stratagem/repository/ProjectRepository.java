package com.fdmgroup.Stratagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.Stratagem.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer>{
	
	@Query("select p from Project p where upper(p.name) like concat('%', upper(:name), '%')")
	public List<Project> findByName(@Param("name") String name);

}
