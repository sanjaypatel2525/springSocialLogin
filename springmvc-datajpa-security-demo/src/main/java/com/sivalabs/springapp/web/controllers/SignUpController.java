package com.sivalabs.springapp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class SignUpController {
 
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String redirectRequestToRegistrationPage() {
        return "redirect:/user/register";
    }
}