package com.company.HomeProject1.controller;

import com.company.HomeProject1.model.Employee;
import com.company.HomeProject1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;
    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }
    @PostMapping("/hello")
    public String postRequest(@RequestParam("text1") String str, Model model) {
        model.addAttribute("sample", str);
        return "hello/response";
    }
    @PostMapping("/hello/db")
    public String postDbRequest(@RequestParam("text2")String id, Model model){
        //Search one
        Employee employee = helloService.getEmployee(id);
        //Save search to model
        model.addAttribute("employee", employee);
        //Screen transition to db.html
        return "hello/db";

    }
}
