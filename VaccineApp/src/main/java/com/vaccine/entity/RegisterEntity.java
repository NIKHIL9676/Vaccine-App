package com.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="REGISTRATION")
@Entity
public class RegisterEntity {
	
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	
	@Column(name="USERNAME")
	private String USERNAME;
	
	@Column(name="EMAIL_ID")
	private String EMAIL_ID;
	
	@Column(name="PASSWORD")
	private String PASSWORD;
	
	@Column(name="GENDER")
	private String GENDER;
	
	@Column(name="MOBILE_NUMBER")
	private String MOBILE_NUMBER;
	
	@Column(name="loginattempts")
	private int loginAttempts;
	
	@Column(name="NO_OF_MEMBERS")
	private int NO_OF_MEMBERS;

	public RegisterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public int getNO_OF_MEMBERS() {
		return NO_OF_MEMBERS;
	}




	public void setNO_OF_MEMBERS(int nO_OF_MEMBERS) {
		NO_OF_MEMBERS = nO_OF_MEMBERS;
	}




	public RegisterEntity(String uSERNAME, String eMAIL_ID, String pASSWORD, String gENDER,
			String mOBILE_NUMBER) {
		super();
		System.out.println("Creating the RegisterEntity object");
		USERNAME = uSERNAME;
		EMAIL_ID = eMAIL_ID;
		PASSWORD = pASSWORD;
		GENDER = gENDER;
		MOBILE_NUMBER = mOBILE_NUMBER;
	}



	public int getLoginAttempts() {
		return loginAttempts;
	}



	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getEMAIL_ID() {
		return EMAIL_ID;
	}

	public void setEMAIL_ID(String eMAIL_ID) {
		EMAIL_ID = eMAIL_ID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getMOBILE_NUMBER() {
		return MOBILE_NUMBER;
	}

	public void setMOBILE_NUMBER(String mOBILE_NUMBER) {
		MOBILE_NUMBER = mOBILE_NUMBER;
	}
	
}
