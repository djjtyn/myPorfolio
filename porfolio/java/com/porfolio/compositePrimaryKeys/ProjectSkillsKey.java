//This class is used to create the primary key for the ProjectSkill table using the Project and Skill Primary Keys

package com.porfolio.compositePrimaryKeys;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProjectSkillsKey implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Short projectId;
	private Short skillId;
	
	public Short getProjectId() {
		return projectId;
	}
	public void setProjectId(Short projectId) {
		this.projectId = projectId;
	}
	public Short getSkillId() {
		return skillId;
	}
	public void setSkillId(Short skillId) {
		this.skillId = skillId;
	}
	
	

}
