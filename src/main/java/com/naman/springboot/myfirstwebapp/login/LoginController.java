package com.naman.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String goToLoginPage(@RequestParam String name, ModelMap modelMap){
        modelMap.put("name",name);
        System.out.println("Request param is:- "+ name);
        return "login";
    }
}
