package com.company.HomeProject1.controller;

import com.company.HomeProject1.form.SignupForm;
import com.company.HomeProject1.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
    @Autowired
    private UserApplicationService userApplicationService;
    /** Display the user signup screen **/
    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form){
        //Get gender
        Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);
        return  "user/signup";
    }
    /** User signup process */
    @PostMapping("/signup")
    public String postSignup(Model model, Locale locale,@ModelAttribute SignupForm form,BindingResult bindingResult){
        //Input check result
        if(bindingResult.hasErrors()){
            
        }
        //Redirect to login screen
        log.info(form.toString());
        //redirect screen
        return "redirect:/login";
    }
}
