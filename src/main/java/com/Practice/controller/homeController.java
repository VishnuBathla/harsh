package com.Practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Practice.model.Login;
import com.Practice.model.UserDtls;
import com.Practice.service.UserService;




@Controller 
public class homeController {
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String homepage() {
		
		return "homepage";
	}
	
	@PostMapping("/login_user")
    public ResponseEntity<String> loginUser(@RequestBody Login loginRequest) {
        UserDtls user = userService.authenticateUser(loginRequest);

        if (user == null) {
            // Return 404 Not Found if user is not found
            return new ResponseEntity<>("No User Found", HttpStatus.NOT_FOUND);
        }

        // Return 200 OK if user is found and authenticated
        return new ResponseEntity<>("Valid User", HttpStatus.OK);
    }

	
	@GetMapping("/register")
	public String register() {
		
		return "register";
	}
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody UserDtls user) {
//	    System.out.println(user.id + " " + user.address + " " + user.email + " " +
//	            user.fullName + " " + user.password + " " + user.qualification);
		user.password = passwordEncoder.encode(user.password);
	    userService.createUser(user);
	    return "login";
	}

}
