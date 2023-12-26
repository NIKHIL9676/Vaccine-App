package com.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.dao.EditMemberEntityDAO;

@Component
public class EditMemberEntityService {
	
	EditMemberEntityDAO editMemberEntityDAO;
	
	@Autowired
	public EditMemberEntityService(EditMemberEntityDAO editMemberEntityDAO) {
		super();
		this.editMemberEntityDAO = editMemberEntityDAO;
	}

	public boolean updateMemberEntity(int MEMBER_ID, String  ID_PROOF_NO , String  No_OF_DOSE , String MEMBER_Name) {
		return editMemberEntityDAO.updateMemberEntity(MEMBER_ID, ID_PROOF_NO, No_OF_DOSE, MEMBER_Name);
		
	}

}