//This class is used to split up skills and projects into front end, back end and full stack types

package com.porfolio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DevelopmentType {
	
	//Primary Key with auto increment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short developmentTypeId;
	
	private String type;

	//Getters and Setters
	public Short getDevelopmentTypeId() {
		return developmentTypeId;
	}

	public void setDevelopmentTypeid(Short id) {
		this.developmentTypeId = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
