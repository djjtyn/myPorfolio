package com.porfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.porfolio.models.GitHubRepo;


public interface GitHubRepository extends JpaRepository<GitHubRepo, Short>{

}
