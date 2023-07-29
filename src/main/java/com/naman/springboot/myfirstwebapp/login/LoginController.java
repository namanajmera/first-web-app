package com.naman.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;

@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/login")
    public String goToLoginPage(@RequestParam String name, ModelMap modelMap){
        modelMap.put("name",name);
        logger.info("Request param is:- "+ name);
        return "login";
    }
}
