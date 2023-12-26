package com.vaccine.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaccine.entity.MemberEntity;
import com.vaccine.entity.RegisterEntity;
import com.vaccine.service.LoginService;
import com.vaccine.service.MailService;
import com.vaccine.service.MemberService;

@Controller
public class LoginController {

	LoginService loginService;
	@Autowired
	MailService mailService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}

	@RequestMapping("/login")
	public String getLoginPage() {
	    return "login"; // Correct path
	}
	@RequestMapping("/register")
	public String getRegisterPage() {
		return "register"; // Correct path
	}

	@RequestMapping("/logintoaccount")
	public String onLoginClick(@RequestParam String EMAIL_ID, String PASSWORD, Model model , HttpServletRequest request, HttpServletResponse response) {

		if (loginService.validateLoginCredentials(EMAIL_ID, PASSWORD)) {

			RegisterEntity entity = loginService.getRegisterEntityByEmail(EMAIL_ID);

			if (entity == null) {
				System.out.println("Invalid email id");
				model.addAttribute("response", "Please enter a valid email id");
			    return "forward:/login"; // Correct path
			}
			int loginCount = entity.getLoginAttempts();

			if (loginCount > 3) {
				mailService.sendMail(entity.getEMAIL_ID(), "Account has been BLOCKED", "\nYour account has been blocked \n because of attempting with wrong password for more than 3 attempts");

				model.addAttribute("errorMessage", "Your account has been blocked please reset your password");
			    return "login"; // Correct path
			}

			if (!(entity == null)) {

				if (PASSWORD.equals(entity.getPASSWORD())) {

					System.out.println("Valid login credentials");
					model.addAttribute("response", "Hi " + entity.getUSERNAME() + "<br> Welcome to the portal");
					if (loginCount > 0) {
						entity.setLoginAttempts(0);
						loginService.updateRegisterEntity(entity);
					}
					
					
					RegisterEntity registerEntity = loginService.getRegisterEntityByEmail(EMAIL_ID);
					System.out.println(registerEntity.getID());
					List<MemberEntity> members = memberService.getAllMemberEntityById(registerEntity.getID());
					System.out.println(members);
					for(MemberEntity member:members) {
						System.out.println(member);
					}
					if(members!=null) {
						
						model.addAttribute("members", members);
					}
					model.addAttribute("email", EMAIL_ID);
					
					return "vaccinehomepage";

				} else {
					
					entity.setLoginAttempts(++loginCount);
					loginService.updateRegisterEntity(entity);

					System.out.println("Invalid password");
					model.addAttribute("password", "Invalid Password");
					model.addAttribute("errorMessage", "You have only " + (4 - loginCount)
							+ " attempts to login otherwise account will be blocked");
					return "forward:/login";

				}
			}

		}
		return "login";

	}

}
