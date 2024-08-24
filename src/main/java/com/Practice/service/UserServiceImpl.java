package com.Practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Practice.model.Login;
import com.Practice.model.UserDtls;
import com.Practice.repository.UserRepository;

@Service 
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDtls createUser(UserDtls user) {
		return userRepo.save(user);
	}

	@Override
	public UserDtls authenticateUser(Login cred) {
		List<UserDtls> users = userRepo.findByEmail(cred.email);
//		System.out.println(cred.password+"hi"+cred.email);
		for (UserDtls user : users) {
//			System.out.println(user.password);
			if(passwordEncoder.matches(cred.password, user.password)) {
//				System.out.println("Hello");
                return user; // Authentication successful
            }
        }
        
        return null; // Authentication failed
    }


}
