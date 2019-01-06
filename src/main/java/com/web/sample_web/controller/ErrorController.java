package com.web.sample_web.controller;


import com.web.sample_web.exception.ActiveAccountException;
import com.web.sample_web.exception.UsernameOrPasswordWrongException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("/error")
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(UsernameOrPasswordWrongException.class)
    public ModelAndView handleUsernameOrPasswordWrongException(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("wrongUser","Username Or Password Wrong");
        return modelAndView;
    }

    @ExceptionHandler(ActiveAccountException.class)
    public ModelAndView handleActiveAccountException(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("activeUser","Please Active your Account");
        return modelAndView;
    }
}
