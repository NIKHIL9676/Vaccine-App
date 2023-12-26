package com.vaccine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaccine.entity.MemberEntity;
import com.vaccine.entity.RegisterEntity;
import com.vaccine.service.EditMemberEntityService;
import com.vaccine.service.LoginService;
import com.vaccine.service.MemberService;

@Controller
public class EditMemberEntityController {

	EditMemberEntityService editMemberEntityService;
	LoginService loginService;
	MemberService memberService;

	@Autowired
	public EditMemberEntityController(EditMemberEntityService editMemberEntityService, LoginService loginService,
			MemberService memberService) {
		super();
		this.editMemberEntityService = editMemberEntityService;
		this.loginService = loginService;
		this.memberService = memberService;
	}

	@RequestMapping("/editMemberEntity")
	public String editMemberEntityFields(@RequestParam String EMAIL_ID, String ID_PROOF, String ID_PROOF_NO,
			String MEMBER_ID, String NO_OF_DOSE, String VACCINE_NAME, String MEMBER_Name, Model model) {

		model.addAttribute("EMAIL_ID", EMAIL_ID);
		model.addAttribute("MEMBER_ID", MEMBER_ID);
		model.addAttribute("No_OF_DOSE", NO_OF_DOSE);
		model.addAttribute("VACCINE_NAME", VACCINE_NAME);
		model.addAttribute("MEMBER_Name", MEMBER_Name);
		model.addAttribute("ID_PROOF", ID_PROOF);
		model.addAttribute("ID_PROOF_NO", ID_PROOF_NO);

		return "editMemberEntity";
	}

	@PostMapping("submitModifiedMemberEntity")
	public String saveModifiedMemberEntity(@RequestParam String MEMBER_ID, String EMAIL_ID, String ID_PROOF_NO,
			String No_OF_DOSE, String MEMBER_Name, Model model) {

		int memberId = Integer.parseInt(MEMBER_ID);

		if (editMemberEntityService.updateMemberEntity(memberId, ID_PROOF_NO, No_OF_DOSE, MEMBER_Name)) {
			model.addAttribute("response", "Updated Succesfully");
			model.addAttribute("response_color", "GREEN");
			System.out.println("Email id --->"+EMAIL_ID);
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

		return "vaccinehomepage";
	}

}
