package com.naman.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/")
    public String goToLoginPage( ModelMap modelMap){
        modelMap.put("name","Naman");
        return "welcome";
    }
}
