package com.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaccine.service.ResetPasswordService;


@Controller
public class ResetPasswordController {

	ResetPasswordService resetPasswordService;
	
	
	@Autowired
	public ResetPasswordController(ResetPasswordService resetPasswordService) {
		super();
		this.resetPasswordService = resetPasswordService;
	}

	


	public ResetPasswordController() {
		super();
		// TODO Auto-generated constructor stub
	}




	@RequestMapping("/resetPassword")
	public String getResetPasswordFields(@RequestParam String EMAIL_ID , String PASSWORD , String Confirm_PASSWORD, Model model) {
		
		String res=resetPasswordService.validateUserData(EMAIL_ID, PASSWORD, Confirm_PASSWORD);
		if(res.equals("valid")) {
			if(resetPasswordService.updatePassword(EMAIL_ID, Confirm_PASSWORD)) {
				model.addAttribute("isPasswordResetted", "Password has been succesfully changed");
				return "login";
			}
		}
		else if(res.equals("email")) {
			model.addAttribute("response","Email id is not registered..");
			return "ResetPassword";
		}
		else if(res.equals("password")) {
			model.addAttribute("password","Password doesn't matched");
			return "ResetPassword";
		}
		
		
		return "ResetPassword";
	}
	
}
