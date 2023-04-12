package com.nature.reactBoot.controller;

import com.nature.reactBoot.database_connection.DBConn;
import com.nature.reactBoot.model.Client;
import com.nature.reactBoot.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    DBConn DBconn = new DBConn();
    ClientService uService = new ClientService();
    Client client = new Client();
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String loginCheck() {

        return "home";
    }
}
