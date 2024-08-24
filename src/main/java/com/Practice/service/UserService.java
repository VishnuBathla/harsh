package com.Practice.service;

import com.Practice.model.Login;
import com.Practice.model.UserDtls;

public interface UserService {
	
	public UserDtls createUser(UserDtls user);
	public UserDtls authenticateUser(Login cred);

}
