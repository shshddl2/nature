package com.nature.reactBoot.controller;

import com.nature.reactBoot.domain.User;
import com.nature.reactBoot.domain.UserForm;
import com.nature.reactBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;

@Controller
public class HomeController {
    String url = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=UTC";
    String id = "root"; // mysql 접속아이디
    String pwd = "1234"; // mysql 접속 비번

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

    @RequestMapping(value = "/registerComplete", method = RequestMethod.POST)
    public String registerComplete(@ModelAttribute UserForm uf) {

        DBConn DBconn = new DBConn();
        UserService uservice = new UserService(DBconn);
        User user = new User();
        user.setUser_id(uf.getUser_id());
        System.out.println(user.getUser_id());
        uservice.insertUser(user);
        return "home";
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String loginCheck() {

        return "home";
    }
}
