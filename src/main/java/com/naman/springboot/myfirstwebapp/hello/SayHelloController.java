package com.naman.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @GetMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! What are you doing???";
    }


}
