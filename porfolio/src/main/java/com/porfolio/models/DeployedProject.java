package com.porfolio.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DeployedProject {
	
	//Primary Key with auto increment
	@Id
	private String url;
	
	//Relation with Project entity	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId", referencedColumnName = "id")
    private Project project;

    //Getters and Setters
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}    
}
