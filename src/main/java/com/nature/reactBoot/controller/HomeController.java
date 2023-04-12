package com.nature.reactBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home() {

        return "home";
    }

    @RequestMapping(value = "/goToLogin")
    public String login() {

        return "login";
    }
    @RequestMapping(value = "/goToRegister")
    public String register() {

        return "register";
    }
    @RequestMapping(value = "/goToDelete")
    public String delete() {

        return "delete";
    }

}
