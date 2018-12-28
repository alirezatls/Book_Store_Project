package com.web.sample_web.controller;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("/error")
public class ErrorController {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ModelAndView handleUserNameException(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        String noAccount = "username or password wrong";
        modelAndView.addObject("noAccount",noAccount);
        return modelAndView;
    }
}
