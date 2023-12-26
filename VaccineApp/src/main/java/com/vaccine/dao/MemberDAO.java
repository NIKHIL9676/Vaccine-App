package com.vaccine.dao;

import java.util.List;

import com.vaccine.entity.MemberEntity;

public interface MemberDAO {

	boolean saveMemberEntity(MemberEntity entity);

	
	List<MemberEntity> getAllMemberEntityById(int id);

	int getRegisterIdByMail(String eMAIL_ID);
	
	int getRegtisterNoOfMembersByMail(String mail);
	boolean updateRegisterEntityNoOfMembers(String email);

}
