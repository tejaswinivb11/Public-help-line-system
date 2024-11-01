package com.CorporationManagement.Model.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.CorporationManagement.Model.Role;
import com.CorporationManagement.Model.User;
import com.CorporationManagement.Model.Repository.UserRepository;
import com.CorporationManagement.Model.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserRepository UR;
	
//	@Autowired 
//	private passwordEncoder pe;
	
	@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User save(UserRegistrationDto URO) {
		User user = new User(URO.getName() , URO.getEmail() ,URO.getAddress() , new BCryptPasswordEncoder().encode(URO.getPassword()) ,Arrays.asList(new Role("ROLE_USER")));
		
		return UR.save(user) ;
	}
	
	//passwordEncoder.encode(URO.getPassword())
	//URO.getPassword() 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = UR.findByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password and.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail() , user.getPassword(), mapRolesToAuthorities(user.getRole()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}