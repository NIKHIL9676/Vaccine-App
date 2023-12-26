package com.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.dao.ResetPasswordDAO;

@Component
public class ResetPasswordService {

	ResetPasswordDAO resetPasswordDAO;

	@Autowired
	public ResetPasswordService(ResetPasswordDAO resetPasswordDAO) {
		super();
		this.resetPasswordDAO = resetPasswordDAO;
	}

	public String validateUserData(String email, String password, String confirm_password) {

		if (!(resetPasswordDAO.checkEntityByMail(email))) {
			return "email";
		}

		if (!(password.equals(confirm_password))) {
			return "password";
		}

		return "valid";
	}

	
	
	public ResetPasswordService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean updatePassword(String email, String password) {
		return resetPasswordDAO.ResetPasswordByMail(email, password);
	}

}
