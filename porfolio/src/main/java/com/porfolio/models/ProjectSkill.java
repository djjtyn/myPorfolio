//This class allows a many to many relation between the project and skill entitites
package com.porfolio.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.porfolio.compositePrimaryKeys.ProjectSkillsKey;

@Entity
public class ProjectSkill {
	
	//Composite Key
	@EmbeddedId
	private ProjectSkillsKey id = new ProjectSkillsKey();
		
	//Relation with the Project entity
	@ManyToOne
	@MapsId("projectId")
	@JoinColumn(name = "projectId")
	private Project project;
		
	//Relation with the Skill entity
	@ManyToOne
	@MapsId("skillId")
	@JoinColumn(name = "SkillId")
	private Skill skill;

	//Getters and Setters
	public ProjectSkillsKey getId() {
		return id;
	}

	public void setId(ProjectSkillsKey id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
