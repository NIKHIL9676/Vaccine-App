package com.vaccine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vaccine.entity.RegisterEntity;
import com.vaccine.service.LoginService;
import com.vaccine.service.RegisterService;

@Controller
public class RegisterController {

    RegisterService registerService;

    @Autowired
    LoginService loginService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @RequestMapping("/home")
    public String getHome() {
        return "home"; // Correct path
    }

    @RequestMapping(value = "/submitDetails", method = RequestMethod.POST)
    public String saveRegisterEntity(@RequestParam String USERNAME, @RequestParam String EMAIL_ID,
            @RequestParam String PASSWORD, @RequestParam String CPASSWORD, @RequestParam String GENDER,
            @RequestParam String MOBILE_NUMBER, Model model) {

        USERNAME = USERNAME.trim();
        EMAIL_ID = EMAIL_ID.trim();
        PASSWORD = PASSWORD.trim();
        CPASSWORD = CPASSWORD.trim();
        GENDER = GENDER.trim();
        MOBILE_NUMBER = MOBILE_NUMBER.trim();

        RegisterEntity entity1 = loginService.getRegisterEntityByEmail(EMAIL_ID);
        if (entity1 != null) {
            model.addAttribute("email", "with this " + EMAIL_ID + " id already been registered ...!");
            return "register";
        }

        RegisterEntity entity = new RegisterEntity(USERNAME, EMAIL_ID, PASSWORD, GENDER, MOBILE_NUMBER);

        // Trim after creating the entity
        entity.setUSERNAME(entity.getUSERNAME().trim());

        String res = registerService.validateRegisterEntity(entity, CPASSWORD);

        if (res.equals("valid")) {
            boolean result = registerService.saveRegisterEntity(entity);

            if (result) {
                model.addAttribute("response", "Registered Successfully <br> Thank You");
                return "register";
            } else {
                model.addAttribute("response", "Something went wrong...!");
            }
        } else if (res.equals("mobile")) {
            model.addAttribute("mobile", "mobile number should be 10 decimals");
        } else if (res.equals("username")) {
            model.addAttribute("username", "Invalid UserName");
        } else if (res.equals("usernameE")) {
            model.addAttribute("username", "The user name should start with a character only..");
        } else if (res.equals("mobileNo")) {
            model.addAttribute("mobile", "mobile Number should start with 6-9");
        } else if (res.equals("password")) {
            model.addAttribute("password", "Password doesn't match");
        }

        return "registerAllDetails";
    }
}
