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

    @GetMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {

        return "<html>" +
                "<head>" +
                "<title> My First HTML Page - Changed</title>" +
                "</head>" +
                "<body>" +
                "My first html page with body - Changed" +
                "</body>" +
                "</html>";
    }
}
