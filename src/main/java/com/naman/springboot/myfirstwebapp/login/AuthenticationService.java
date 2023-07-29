package com.naman.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authentication(String username, String password){
        return  (username.equalsIgnoreCase("naman") && password.equalsIgnoreCase("dummy"));
    }
}
