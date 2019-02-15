package com.web.sample_web.controller;

import com.web.sample_web.dao.MemberDao;
import com.web.sample_web.entity.Book;
import com.web.sample_web.exception.ActiveAccountException;
import com.web.sample_web.exception.UsernameOrPasswordWrongException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
//@SessionAttributes(value = {"user"})
public class LoginController {

    @Autowired
    MemberDao memberDao;

    @GetMapping(path = "/login")
    public String showLoginPage(Model model) {
        return "login";
    }

}
