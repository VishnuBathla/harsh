package com.Practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Login {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	public String email;
	public String password; 

	
	
	
}
