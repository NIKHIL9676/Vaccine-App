package com.vaccine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.dao.MemberDAO;
import com.vaccine.entity.MemberEntity;

@Component
public class MemberService {

	MemberDAO memberDAO;
	
	
	@Autowired
	public MemberService(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
	}

	public boolean updateRegisterEntityNoOfMembers(String  email) {
		return memberDAO.updateRegisterEntityNoOfMembers(email);
	}

	public int getRegisterIdByMail(String EMAIL_ID) 
	
	{
		return memberDAO.getRegisterIdByMail(EMAIL_ID);
	}
	
	public boolean saveMemberEntity(MemberEntity entity) {
		return memberDAO.saveMemberEntity(entity);
	}
	
	public List<MemberEntity> getAllMemberEntityById(int id){
		System.out.println(id+" id in member service");
		return memberDAO.getAllMemberEntityById(id);
	}
	
	
	public int getRegtisterNoOfMembersByMail(String email) {
		return memberDAO.getRegtisterNoOfMembersByMail(email);
	}
	
}
