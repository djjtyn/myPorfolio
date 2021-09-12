package com.porfolio.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project {
	
	//Primary Key with auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short id;
	
	private String name;
	
	private String description;
	
	//Relation with DevelopmentType entity
	@ManyToOne
	@JoinColumn(name = "developmentTypeId")
	private DevelopmentType developmentType;
	
	//Relation with GitHubRepo entity
	@OneToOne(mappedBy = "project", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private GitHubRepo gitHubRepo;
	
	//Relation with LiveProject entity
	@OneToOne(mappedBy = "project", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private DeployedProject deployedProject;
	
	//Relation with DatabaseDsign entity
	@OneToOne(mappedBy = "project", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private DatabaseDesign databaseDesign;
	
	//Relation with ProjectSkill entity
	@OneToMany(mappedBy = "project")
	private List<ProjectSkill> skills;
	
	//Getters and Setters
	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DevelopmentType getDevelopmentType() {
		return developmentType;
	}

	public void setDevelopmentType(DevelopmentType developmentType) {
		this.developmentType = developmentType;
	}

	public GitHubRepo getGitHubRepo() {
		return gitHubRepo;
	}

	public void setGitHubRepo(GitHubRepo gitHubRepo) {
		this.gitHubRepo = gitHubRepo;
	}

	public DeployedProject getDeployedProject() {
		return deployedProject;
	}

	public void setDeployedProject(DeployedProject deployedProject) {
		this.deployedProject = deployedProject;
	}

	public List<ProjectSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<ProjectSkill> skills) {
		this.skills = skills;
	}

	public DatabaseDesign getDatabaseDesign() {
		return databaseDesign;
	}

	public void setDatabaseDesign(DatabaseDesign databaseDesign) {
		this.databaseDesign = databaseDesign;
	}	
}
