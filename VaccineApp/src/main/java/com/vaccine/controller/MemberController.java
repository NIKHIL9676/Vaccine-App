package com.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaccine.entity.MemberEntity;
import com.vaccine.entity.RegisterEntity;
import com.vaccine.service.LoginService;
import com.vaccine.service.MemberService;

@Controller
public class MemberController {

	MemberService memberService;
	LoginService loginService;

	@Autowired
	public MemberController(MemberService memberService, LoginService loginService) {
		super();
		this.memberService = memberService;
		this.loginService = loginService;
	}

	@RequestMapping("/addmember")
	public String getAddMemberRegistrationPage(@RequestParam String email, Model model) {
		model.addAttribute("email", email);
		return "memberRegistration";
	}

	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/registerMember")
	public String registerMemberEntity(@RequestParam String MEMBER_Name, String GENDER, String DATE_OF_BIRTH,
			String ID_PROOF, String No_OF_DOSE, String ID_PROOF_NO, String VACCINE_NAME, String EMAIL_ID, Model model) {

		int NO_OF_MEMBERS = memberService.getRegtisterNoOfMembersByMail(EMAIL_ID);
		if (!(NO_OF_MEMBERS < 5)) {
			model.addAttribute("NO_OF_MEMBERS", "Your can add only 5 family members");
			model.addAttribute("email", EMAIL_ID);
			RegisterEntity registerEntity = loginService.getRegisterEntityByEmail(EMAIL_ID);
			System.out.println(registerEntity.getID());
			List<MemberEntity> members = memberService.getAllMemberEntityById(registerEntity.getID());
			System.out.println(members);
			for (MemberEntity member : members) {
				System.out.println(member);
			}
			if (members != null) {
				model.addAttribute("members", members);
			}
			return "vaccinehomepage";

		} 
		
		System.out.println(MEMBER_Name);
		System.out.println(GENDER);
		System.out.println(DATE_OF_BIRTH);
		System.out.println(ID_PROOF);
		System.out.println(ID_PROOF_NO);
		System.out.println(VACCINE_NAME);
		System.out.println(EMAIL_ID);
		int id = memberService.getRegisterIdByMail(EMAIL_ID);

		System.out.println("RegisterEntity Id " + id);
		MemberEntity entity = new MemberEntity(MEMBER_Name, GENDER, DATE_OF_BIRTH, ID_PROOF, ID_PROOF_NO, VACCINE_NAME,
				Integer.parseInt(No_OF_DOSE), id);
		System.out.println("Member Entity created");
		boolean isMemberEntitySaved = memberService.saveMemberEntity(entity);

		if (isMemberEntitySaved) {
			System.out.println("Member Entity Saved successfully");
			memberService.updateRegisterEntityNoOfMembers(EMAIL_ID);

			model.addAttribute("email", EMAIL_ID);
			RegisterEntity registerEntity = loginService.getRegisterEntityByEmail(EMAIL_ID);
			System.out.println(registerEntity.getID());
			List<MemberEntity> members = memberService.getAllMemberEntityById(registerEntity.getID());
			System.out.println(members);
			for (MemberEntity member : members) {
				System.out.println(member);
			}
			if (members != null) {
				model.addAttribute("members", members);
			}

			
		} else {
			model.addAttribute("email", EMAIL_ID);
			model.addAttribute("response", "Something went wrong");
		}
		
		return "vaccinehomepage";
	}

	
}
