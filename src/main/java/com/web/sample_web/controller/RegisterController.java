package com.web.sample_web.controller;

import com.web.sample_web.dao.MemberDao;
import com.web.sample_web.entity.Member;
import com.web.sample_web.service.MemberService;
import com.web.sample_web.util.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class RegisterController {


    @Autowired
    MemberDao memberDao;

    @Autowired
    MailService mailService;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    MemberService memberService;

    @GetMapping(value = "/register")
    public String showRegisterPage(ModelMap modelMap) {
        modelMap.addAttribute("mem", new Member());
        return "register";
    }

    @PostMapping(value = "/performRegister")
    public ModelAndView addNewMember(@ModelAttribute("mem") @Valid Member mem,
                                     BindingResult result,
                                     WebRequest request,
                                     ModelMap modelMap) {

        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("register");
            return modelAndView;
        }

            Member m = memberDao.saveMember(mem);
            if (m != null) {
                // mailService.sendEmail("alirezatl135@gmail.com","simple","from alireza");
                String appUrl = request.getContextPath();

                //pass registered mem , locale , context path
                //eventPublisher.publishEvent(new OnRegistrationCompleteEvent(m,request.getLocale(),appUrl));
                String token = UUID.randomUUID().toString();

                //save to database
                memberService.createVerificationToken(m, token);

                //email address
                String recipientAddress = m.getEmail();
                //email subject
                String subject = "Registration Confirmation";
                //email message
                String confirmationUrl
                        = appUrl + "/regitrationConfirm?token=" + token;
                //String message = messages.getMessage("message.regSucc", null, event.getLocale());

                mailService.sendEmail(recipientAddress,subject,"http://localhost:9000" + confirmationUrl);

                modelAndView.setViewName("confirm_registration");
            }
            return modelAndView;
    }

}
