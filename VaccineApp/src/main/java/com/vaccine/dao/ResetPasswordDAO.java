package com.vaccine.dao;

public interface ResetPasswordDAO {

	boolean ResetPasswordByMail(String email,String password);
	
	boolean checkEntityByMail(String email);
	
}
