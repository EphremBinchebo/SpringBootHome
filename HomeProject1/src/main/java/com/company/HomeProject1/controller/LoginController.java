package com.company.HomeProject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    /** Display Login Screen **/
    @GetMapping("/login")
    public String getLogin(){
        return "login/login";
    }
}
