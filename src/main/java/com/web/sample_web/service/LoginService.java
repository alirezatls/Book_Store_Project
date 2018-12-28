package com.web.sample_web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean loginValidation(String user, String password) {
        if(user.equals("alireza") && password.equals("1234")) {
            return true;
        }
        return false;
    }
}
