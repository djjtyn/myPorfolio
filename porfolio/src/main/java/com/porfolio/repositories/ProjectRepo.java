package com.porfolio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.models.DevelopmentType;
import com.porfolio.models.Project;
import com.porfolio.models.Skill;

public interface ProjectRepo extends JpaRepository<Project, Short>{
	
	List<Project> findByDevelopmentType(DevelopmentType type);
}
