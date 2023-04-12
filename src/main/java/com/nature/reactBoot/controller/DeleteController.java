package com.nature.reactBoot.controller;

import com.nature.reactBoot.database_connection.DBConn;
import com.nature.reactBoot.model.DeleteForm;
import com.nature.reactBoot.model.Client;
import com.nature.reactBoot.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteController {
    @RequestMapping(value = "/deleteComplete", method = RequestMethod.POST)
    public String delete(@ModelAttribute DeleteForm delForm){
        return "home";
    }
    DBConn DBconn = new DBConn();
    ClientService uService = new ClientService();
    Client client = new Client();

}
