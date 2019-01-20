package com.web.sample_web.controller;

import com.web.sample_web.dao.MemberDao;
import com.web.sample_web.entity.Book;
import com.web.sample_web.entity.Member;
import com.web.sample_web.exception.ActiveAccountException;
import com.web.sample_web.exception.UsernameOrPasswordWrongException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String showLoginPage() {
        return "login";
    }


    @PostMapping(path = "/performLogin")
    public String loginToShop(@RequestParam("userName")  String user,
                              @RequestParam("password") String pass,
                              HttpSession session) {
        Member member = memberDao.getByUserNameAndPassword(user, pass);

        if(member == null) {
            throw new UsernameOrPasswordWrongException("wrong info");
        }
        else if(member !=null) {
            if(member.isEnabled()) {
                Map<Book,Integer> cart = new HashMap<>();
                session.setAttribute("cart",cart);
                return "index";
            }
            else {
                throw new ActiveAccountException("no Active Account");
            }
        }
        else throw new IllegalStateException();
    }




}
