package com.web.sample_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller("/wlc")
public class WelcomeController {

    @GetMapping
    public String showWelcomePage() {
        return "index";
    }
}
