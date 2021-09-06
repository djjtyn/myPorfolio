package com.porfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.porfolio.models.Skill;
import com.porfolio.repositories.SkillRepo;

@Controller
public class controller {
	
	//Repositories
	@Autowired
	SkillRepo skillRepo;
	
	@GetMapping("/")
	public String displayAboutMePage() {
		return "aboutMe.html";
	}
	
	//My Skills
	@GetMapping("/mySkills")
	public String displayMySKillsPage(Model model) {
		//Get the list of skills from the database and add to the page model
		List<Skill> skillList = skillRepo.findAll();
		model.addAttribute("skillList", skillList);
		return "mySkills.html";
	}
}
