package com.porfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.models.DeployedProject;

public interface DeployedProjectRepo extends JpaRepository<DeployedProject, Short> {

}
