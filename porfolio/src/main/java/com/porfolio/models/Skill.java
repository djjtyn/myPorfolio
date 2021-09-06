package com.porfolio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Skill {
	
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
}
