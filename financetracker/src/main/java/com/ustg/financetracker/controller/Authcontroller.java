package com.ustg.financetracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Authcontroller {

    @PostMapping("/signup")
    public String register() {
        return "sign up successfull";
    }

    @GetMapping("/login")
    public String login() {
        return "login successfull";
    }

}
