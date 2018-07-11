package com.greenfoxacademy.p2pchat.controllers;

import com.greenfoxacademy.p2pchat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class WebController {
    UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }

    @Autowired


    @GetMapping("/")
    public String getMainPage(){
        return "index";
    }

    @GetMapping("/register")
    public String getRegisterPage(){
        return "/register";
    }

    @PostMapping("/registeraccount")
    public String saveNewUser(@ModelAttribute String username){
        userService.saveUser(username);
        if (userService.checkIfUserPresent()){
            return "redirect:/";
        }
        else{
            return "redirect:/register";

        }

    }
}
