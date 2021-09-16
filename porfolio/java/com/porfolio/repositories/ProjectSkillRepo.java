package com.porfolio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.porfolio.compositePrimaryKeys.ProjectSkillsKey;
import com.porfolio.models.ProjectSkill;

public interface ProjectSkillRepo extends JpaRepository<ProjectSkill, ProjectSkillsKey> {
	
	//This method will get all skills listed for projects
	@Query(value = "SELECT DISTINCT skillId FROM ProjectSkill", nativeQuery = true)
	List<Short> getAllProjectSkills();
	
	//Select all projects that match the given tool id
	@Query(value = "SELECT projectId FROM ProjectSkill WHERE SkillId = ?1", nativeQuery = true)
	List<Short> getProjectIdForTool(Short toolId);

}
