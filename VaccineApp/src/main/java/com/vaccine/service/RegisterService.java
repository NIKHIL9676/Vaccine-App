package com.vaccine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaccine.dao.RegisterDAO;
import com.vaccine.entity.RegisterEntity;

@Component
public class RegisterService {

    RegisterDAO registerDAO;

    @Autowired
    public RegisterService(RegisterDAO registerDAO) {
        super();
        System.out.println("Inside the Register service constructor");
        System.out.println();
        this.registerDAO = registerDAO;
    }

    public String validateRegisterEntity(RegisterEntity entity, String cPassword) {
        String un = entity.getUSERNAME();
        String password = entity.getPASSWORD();
        String mobileNo = "" + entity.getMOBILE_NUMBER();
        System.out.println("inside the validating registration entity");
        System.out.println();

        System.out.println("Username: " + un);
        System.out.println("Password: " + password);
        System.out.println("Confirm Password: " + cPassword);

        if (!Character.isLetter(un.charAt(0))) {
            return "usernameE";
        }

        for (int i = 1; i < un.length(); i++) {
            char currentChar = un.charAt(i);
            if (!(Character.isLetter(currentChar) || Character.isDigit(currentChar) || currentChar == ' ')) {
                System.out.println("Invalid character in username: " + currentChar);
                System.out.println();
                System.out.println();
                return "username";
            }
        }

        if (!(cPassword.equals(password))) {
            System.out.println("Password and confirm password do not match.");
            System.out.println();
            System.out.println();
            return "password";
        }

        if (!(mobileNo.length() == 10)) {
            return "mobile";
        } else if (!((mobileNo.charAt(0) >= 54) && mobileNo.charAt(0) <= 57)) {
            return "mobileNo";
        }

        return "valid";
    }

    public boolean saveRegisterEntity(RegisterEntity entity) {
        System.out.println("Inside the save registerEntity method in the RegisterService class");
        System.out.println();
        boolean res = registerDAO.saveRegisterEntity(entity);
        return res;
    }
}
