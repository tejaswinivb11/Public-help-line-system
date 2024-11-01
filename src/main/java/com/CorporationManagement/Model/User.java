package com.CorporationManagement.Model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "user" , uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "password")
	private String password;
	
	
	@ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinTable(
			name = "User_Roles" , 
			joinColumns = @javax.persistence.JoinColumn(
					name = "user_id" , referencedColumnName = "id"),
			inverseJoinColumns = @javax.persistence.JoinColumn(
					name = "role_id" , referencedColumnName =  "id")
			)
	private Collection<Role> Role;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Collection<Role> getRole() {
		return Role;
	}


	public void setRole(Collection<Role> role) {
		Role = role;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", password="
				+ password + ", Role=" + Role + "]";
	}


	public User(String name, String email, String address, String password,
			Collection<com.CorporationManagement.Model.Role> role) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
		Role = role;
	}


	public User() {
		
	}

	
}
