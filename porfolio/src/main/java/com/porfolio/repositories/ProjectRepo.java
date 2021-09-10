package com.porfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.models.Project;

public interface ProjectRepo extends JpaRepository<Project, Short>{

}
