package com.naman.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
@SessionAttributes("name")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/login")
    public String goToLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
        if (!authenticationService.authentication(name,password)){
            modelMap.put("error","Oops!! you entered wrong name or password");
            return "login";
        }
        modelMap.put("name",name);
        return "welcome";
    }
}
