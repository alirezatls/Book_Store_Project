package com.web.sample_web.controller;


import com.sun.mail.util.MailConnectException;
import com.web.sample_web.service.exception.ActiveAccountException;
import com.web.sample_web.service.exception.UniqueUsernameException;
import com.web.sample_web.service.exception.UsernameOrPasswordWrongException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.UnknownHostException;

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

    @ExceptionHandler(UniqueUsernameException.class)
    public String handleUniqueUsernameException(HttpServletRequest request, HttpServletResponse response, ModelMap modelmap) {
        modelmap.put("takenUser","This username is taken by another user");
        return "redirect:/register";
    }


    @ExceptionHandler({MailConnectException.class,UnknownHostException.class})
    public String handleUnknownHostException(HttpServletRequest request, HttpServletResponse response) {
        return "network";
    }
}
