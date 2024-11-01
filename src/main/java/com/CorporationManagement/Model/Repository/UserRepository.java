package com.CorporationManagement.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CorporationManagement.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User , Integer>{
	User findByEmail(String email);
}
