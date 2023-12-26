package com.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.dao.DeleteMemberEntityDAO;

@Component
public class DeleteMemberEntityService {

	DeleteMemberEntityDAO deleteMemberEntityDAO;

	@Autowired
	public DeleteMemberEntityService(DeleteMemberEntityDAO deleteMemberEntityDAO) {
		super();
		this.deleteMemberEntityDAO = deleteMemberEntityDAO;
	}

	public boolean deleteMemberEntityById(int MEMBER_ID) {
		return deleteMemberEntityDAO.deleteMemberEntityById(MEMBER_ID);
	}
	
	public boolean updateRegisterEntityNoOfMembers(String email) {
		return deleteMemberEntityDAO.updateRegisterEntityNoOfMembers(email);
	}

}
