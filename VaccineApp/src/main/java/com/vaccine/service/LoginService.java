package com.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.dao.LoginDAO;
import com.vaccine.entity.RegisterEntity;

@Component
public class LoginService {

	
	LoginDAO loginDAO;
	@Autowired
	public LoginService(LoginDAO loginDAO) {
		super();
		this.loginDAO = loginDAO;
	}

	public LoginService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean validateLoginCredentials(String emailId , String password ) {
		
		if(emailId.isEmpty() ||  password.isEmpty() ) {
			return false;
		}
		
		
		return true;
		
	}
	
	public boolean updateRegisterEntity(RegisterEntity entity) {
		return loginDAO.updateEntityLoginAttempts(entity);
	}
	
	public RegisterEntity getRegisterEntityByEmail (String email) {
		
		return loginDAO.getRegisterEntityByEmail(email);
	}
	
}
