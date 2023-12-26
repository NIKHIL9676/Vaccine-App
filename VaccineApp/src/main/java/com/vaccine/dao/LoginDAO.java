package com.vaccine.dao;

import com.vaccine.entity.RegisterEntity;

public interface LoginDAO {
	RegisterEntity getRegisterEntityByEmail(String email) ; 
	boolean updateEntityLoginAttempts(RegisterEntity entity);
}
