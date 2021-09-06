package com.porfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.models.Skill;

public interface SkillRepo extends JpaRepository<Skill, Short>{

}
