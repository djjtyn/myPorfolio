package com.porfolio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.porfolio.models.DevelopmentType;
import com.porfolio.models.Skill;
import com.porfolio.repositories.DevelopmentTypeRepo;
import com.porfolio.repositories.SkillRepo;

@Controller
public class controller {
	
	//Repositories
	@Autowired
	SkillRepo skillRepo;
	
	@Autowired
	DevelopmentTypeRepo developmentTypeRepo;
	
	@GetMapping("/")
	public String displayAboutMePage() {
		return "aboutMe.html";
	}
	
	//My Skills
	@RequestMapping("/mySkills")
	public String displayMySKillsPage(Model model, @RequestParam("filterSkills") Optional<Short> developmentTypeId) {
		System.out.println(developmentTypeId);
		List<Skill> skillList;
		String filterOption = "All";
		//Get the list of development types to be used for filtering
		List<DevelopmentType> developmentTypeList = developmentTypeRepo.findAll();
		model.addAttribute("developmentTypeList", developmentTypeList);
		//Check if a filter option was selected
		if(developmentTypeId.isPresent()) {
			//Determine what filter was selected
			Short id = developmentTypeId.get();
			//If the id is -1 display all skills
			if(id == -1) {
				skillList = skillRepo.findAll();
			} else {
				DevelopmentType type = developmentTypeRepo.getById(id);
				filterOption = type.getType();
				skillList = skillRepo.findByDevelopmentType(type);
			}
		} else { 
			skillList = skillRepo.findAll();
		}
		model.addAttribute("filterOption", filterOption);
		model.addAttribute("skillList", skillList);
		return "mySkills.html";
	}
}
