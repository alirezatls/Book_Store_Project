package com.web.sample_web.controller;

import com.web.sample_web.entity.Members;
import com.web.sample_web.entity.VerificationToken;
import com.web.sample_web.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

@Controller
public class ActiveRegistration {

    @Autowired
    MemberService memberService;

    @GetMapping("/regitrationConfirm")
    public String confirmRegistration(@RequestParam("token") String token,
                                      WebRequest request,
                                      RedirectAttributes redirect) {

        Locale locale = request.getLocale();

        //get token from database
        VerificationToken verificationToken = memberService.getVerificationToken(token);
        if (verificationToken == null) {
          //  String message = messages.getMessage("auth.message.invalidToken", null, locale);
         //   model.addAttribute("message", message);
            return "redirect:/error";
        }

        Members member = verificationToken.getMember();

        member.setEnabled(true);
        memberService.saveRegisteredMember(member);
        String activeMessage = "thanke you for activing your account.now you can login";
        redirect.addFlashAttribute("activeMessage",activeMessage);
        return "redirect:/login";

    }
}
