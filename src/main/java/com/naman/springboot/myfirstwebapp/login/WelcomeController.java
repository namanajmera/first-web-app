package com.naman.springboot.myfirstwebapp.login;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/")
    public String goToLoginPage( ModelMap modelMap){
        modelMap.put("name",getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
