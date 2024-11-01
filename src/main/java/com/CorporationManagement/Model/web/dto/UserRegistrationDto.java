package com.CorporationManagement.Model.web.dto;

public class UserRegistrationDto {
	private String Name;
	private String Email;
	private String Address;
	private String Password;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public UserRegistrationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public UserRegistrationDto(String name, String email, String address, String password) {
		super();
		Name = name;
		Email = email;
		Address = address;
		Password = password;
	}
}
