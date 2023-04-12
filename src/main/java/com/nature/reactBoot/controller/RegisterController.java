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

        DBConn DBconn = new DBConn();
        ClientService clService = new ClientService();
        Client client = new Client();
        client.setClient_Id(resForm.getClient_Id());
        client.setClient_Password(resForm.getClient_Password());
        client.setClient_Nickname(resForm.getClient_Nickname());
        client.setClient_Email(resForm.getClient_Email());
        client.setClient_Phone(resForm.getClient_Phone());
        clService.insertUser(client);
        return "home";
    }

}
