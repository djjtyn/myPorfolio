package com.porfolio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.porfolio.emailService.EmailSender;
import com.porfolio.models.DevelopmentType;
import com.porfolio.models.Skill;
import com.porfolio.repositories.DevelopmentTypeRepo;
import com.porfolio.repositories.SkillRepo;

@Controller
public class controller {
	
	//Environment Variables
	@Value("${MAIL_USERNAME}")
	private String recipentEmailAddress;
	
	@Autowired
	private JavaMailSender mailSender;
	
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
				skillList = skillRepo.findAllByOrderByNameAsc();
			} else {
				DevelopmentType type = developmentTypeRepo.getById(id);
				filterOption = type.getType();
				skillList = skillRepo.findByDevelopmentTypeOrderByNameAsc(type);
			}
		} else { 
			skillList = skillRepo.findAllByOrderByNameAsc();
		}
		model.addAttribute("filterOption", filterOption);
		model.addAttribute("skillList", skillList);
		return "mySkills.html";
	}
	
	//Display Contact Form
	@GetMapping("/contact")
	public String displayContactForm() {
		return "contact.html";
	}
	
	//Handle Contact Form submit 
	@PostMapping("/contact")
	public String handleContactFormSubmit(RedirectAttributes attributes, @RequestParam("senderName") String senderName, 
											@RequestParam("senderEmail") String senderEmail, @RequestParam("subject") String subject, 
											@RequestParam("message") String message) {
		String status;
		//If the subject is empty set a default value
		if(subject.equals("")) {
			subject = "No Subject";
		}
		//If the sender name is empty set a default value
		if(senderName.equals("")) {
			senderName = "Unknown";
		}
		try {
			//Instantiate the EmailSender class
			EmailSender emailSender = new EmailSender();
			String emailContent = "Sent From : " + senderEmail + "\nSender Name: " + senderName + "\nMessage Content\n" + message;
			emailSender.sendEmail(recipentEmailAddress, emailContent, subject, mailSender);
			status = "Your email was sent!";
			attributes.addFlashAttribute("status", status);
			return "redirect:/contact";
	
		} catch (Exception e) {
			e.printStackTrace();
			status = "Your email was unable to be sent";
			attributes.addFlashAttribute("status", status);
			return "redirect:/contact";
		}
	}
}
