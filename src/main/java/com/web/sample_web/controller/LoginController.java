package com.web.sample_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(path = "/login")
    public String showLoginPage() {
        return "login";
    }


    @GetMapping("/logout_success")
    public String logout() {
        return "index";
    }

}
