package com.nature.reactBoot.controller;

import com.nature.reactBoot.database_connection.DBConn;
import com.nature.reactBoot.model.RegisterForm;
import com.nature.reactBoot.model.Client;
import com.nature.reactBoot.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    @RequestMapping(value = "/registerComplete", method = RequestMethod.POST)
    public String registerComplete(@ModelAttribute RegisterForm resForm) {
        System.out.println("controller :: " + resForm.getClient_id());
        DBConn DBconn = new DBConn();
        ClientService clService = new ClientService();
        Client client = new Client();
        client.setClient_id(resForm.getClient_id());
        client.setClient_password(resForm.getClient_password());
        client.setClient_nickname(resForm.getClient_nickname());
        client.setClient_email(resForm.getClient_email());
        client.setClient_phone(resForm.getClient_phone());
        clService.insertClient(client);
        return "home";
    }

}
