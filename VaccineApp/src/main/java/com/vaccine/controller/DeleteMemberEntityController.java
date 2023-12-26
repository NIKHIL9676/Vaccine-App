package com.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaccine.entity.MemberEntity;
import com.vaccine.entity.RegisterEntity;
import com.vaccine.service.DeleteMemberEntityService;
import com.vaccine.service.LoginService;
import com.vaccine.service.MemberService;

@Controller
public class DeleteMemberEntityController {

	DeleteMemberEntityService deleteMemberEntityService;
	MemberService memberService;
	LoginService loginService;

	@Autowired
	public DeleteMemberEntityController(DeleteMemberEntityService deleteMemberEntityService,
			MemberService memberService, LoginService loginService) {
		super();
		this.deleteMemberEntityService = deleteMemberEntityService;
		this.memberService = memberService;
		this.loginService = loginService;
	}

	@RequestMapping("/deleteMemberEntity")
	public String deleteMemberEntity(@RequestParam String MEMBER_ID, int id, String EMAIL_ID, Model model) {

		if (deleteMemberEntityService.deleteMemberEntityById(Integer.parseInt(MEMBER_ID))) {

			if (deleteMemberEntityService.updateRegisterEntityNoOfMembers(EMAIL_ID)) {

				model.addAttribute("response", "Deleted Successfully");
				model.addAttribute("response_color", "RED");
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

			}
		}

		return "vaccinehomepage";
	}

}
