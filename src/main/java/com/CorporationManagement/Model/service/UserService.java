package com.CorporationManagement.Model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.CorporationManagement.Model.User;
import com.CorporationManagement.Model.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto UROs);
}
