package com.CorporationManagement.Model.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CorporationManagement.Model.service.UserServiceImpl;
import com.CorporationManagement.Model.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegestrationController {
	
	@Autowired
	private UserServiceImpl USI;
	
	@ModelAttribute("User")
	public UserRegistrationDto URD() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String ShowRegestration() {
		return "registration";
	}
	
	@PostMapping
	public String RegestrationUserAcc(@ModelAttribute("User") UserRegistrationDto URD) {
		USI.save(URD);
		System.out.println("saved...");
		return "redirect:/registration?success";
	}
}
