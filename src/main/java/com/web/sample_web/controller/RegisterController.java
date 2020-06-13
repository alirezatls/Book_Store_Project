package com.web.sample_web.controller;

import com.web.sample_web.domain.Members;
import com.web.sample_web.service.exception.UniqueUsernameException;
import com.web.sample_web.service.MemberService;
import com.web.sample_web.service.bean.MemberRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final MemberService memberService;

    @GetMapping(value = "/register")
    public String showRegisterPage(ModelMap modelMap) {
        modelMap.addAttribute("mem", new Members());
        return "register";
    }

    @PostMapping(value = "/performRegister")
    public ModelAndView addNewMember(@ModelAttribute("mem") @Valid MemberRequest mem, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("register");
            return modelAndView;
        }
        Members userName = memberService.getByUserName(mem.getUserName());
        if (userName == null) {
            memberService.saveMember(toMember(mem));
        } else {
            throw new UniqueUsernameException();
        }

        modelAndView.setViewName("confirm_registration");
        return modelAndView;
    }

    private Members toMember(MemberRequest req) {
        return Members.builder().name(req.getName())
                .userName(req.getUserName())
                .password(req.getPassword())
                .email(req.getEmail())
                .build();
    }
}
