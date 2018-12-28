package com.web.sample_web.controller;

import com.web.sample_web.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"user"})
public class LoginController {

   // @Autowired
  //  SecurityService securityService;

  //  @Autowired
  //  MemberDao memberDao;

  //  @Autowired
  //  BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping(value = "/login")
    public String showLoginPage() {
        return "login";
    }


    @PostMapping(value = "/perform_login")
    public String loginToShop(@RequestParam("userName") String user,
                              @RequestParam("password") String pass,
                              ModelMap modelMap) {
        List<Book> books = new ArrayList<>();
       // boolean loginValidation = securityService.login(user,pass);
        if (true) {
            modelMap.put("user",user);
           // modelMap.put("orderBook",books);
            return "index";
        }
        else {
            String noAccount = "username or password is wrong";
            modelMap.addAttribute("noAccount");
            return "login";
        }

    }




}
