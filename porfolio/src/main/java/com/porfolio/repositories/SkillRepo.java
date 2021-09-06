package com.porfolio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.models.DevelopmentType;
import com.porfolio.models.Skill;

public interface SkillRepo extends JpaRepository<Skill, Short>{
	
	List<Skill> findByDevelopmentType(DevelopmentType type);
}
