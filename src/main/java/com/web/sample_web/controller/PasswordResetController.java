package com.web.sample_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PasswordResetController {

    @GetMapping("/reset")
    public String showResetPasswordPage() {
        return "reset";
    }
}
