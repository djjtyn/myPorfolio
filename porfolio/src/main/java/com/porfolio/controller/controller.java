package com.porfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {
	
	@GetMapping("/")
	public String displayAboutMePage() {
		return "aboutMe.html";
	}
	
	@GetMapping("/mySkills")
	public String displayMySKillsPage() {
		return "mySkills.html";
	}
}
