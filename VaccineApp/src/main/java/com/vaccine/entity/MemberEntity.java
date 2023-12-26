package com.vaccine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class MemberEntity {

	@Id
	@Column(name = "MEMBER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int MEMBER_ID;

	@Column(name = "MEMBER_Name")
	private String MEMBER_Name;

	@Column(name = "GENDER")
	private String GENDER;

	@Column(name = "DATE_OF_BIRTH")
	private String DATE_OF_BIRTH;

	@Column(name = "ID_PROOF")
	private String ID_PROOF;

	@Column(name = "ID_PROOF_NO")
	private String ID_PROOF_NO;

	@Column(name = "VACCINE_NAME")
	private String VACCINE_NAME;

	@Column(name = "No_OF_DOSE")
	private int No_OF_DOSE;

	@Column(name = "ID")
	private int ID;

	public MemberEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MEMBER_Name+" , "+GENDER+" , "+DATE_OF_BIRTH+" , "+VACCINE_NAME+" , "+No_OF_DOSE;
	}
	public MemberEntity( String mEMBER_Name, String gENDER, String dATE_OF_BIRTH, String iD_PROOF,
			String iD_PROOF_NO, String vACCINE_NAME, int no_OF_DOSE, int iD) {
		super();
		MEMBER_Name = mEMBER_Name;
		GENDER = gENDER;
		DATE_OF_BIRTH = dATE_OF_BIRTH;
		ID_PROOF = iD_PROOF;
		ID_PROOF_NO = iD_PROOF_NO;
		VACCINE_NAME = vACCINE_NAME;
		No_OF_DOSE = no_OF_DOSE;
		ID = iD;
	}

	public int getMEMBER_ID() {
		return MEMBER_ID;
	}

	public void setMEMBER_ID(int mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}

	public String getMEMBER_Name() {
		return MEMBER_Name;
	}

	public void setMEMBER_Name(String mEMBER_Name) {
		MEMBER_Name = mEMBER_Name;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getDATE_OF_BIRTH() {
		return DATE_OF_BIRTH;
	}

	public void setDATE_OF_BIRTH(String dATE_OF_BIRTH) {
		DATE_OF_BIRTH = dATE_OF_BIRTH;
	}

	public String getID_PROOF() {
		return ID_PROOF;
	}

	public void setID_PROOF(String iD_PROOF) {
		ID_PROOF = iD_PROOF;
	}

	public String getID_PROOF_NO() {
		return ID_PROOF_NO;
	}

	public void setID_PROOF_NO(String iD_PROOF_NO) {
		ID_PROOF_NO = iD_PROOF_NO;
	}

	public String getVACCINE_NAME() {
		return VACCINE_NAME;
	}

	public void setVACCINE_NAME(String vACCINE_NAME) {
		VACCINE_NAME = vACCINE_NAME;
	}

	public int getNo_OF_DOSE() {
		return No_OF_DOSE;
	}

	public void setNo_OF_DOSE(int no_OF_DOSE) {
		No_OF_DOSE = no_OF_DOSE;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
