package com.nature.reactBoot.controller;

import com.nature.reactBoot.database_connection.DBConn;
import com.nature.reactBoot.model.Client;
import com.nature.reactBoot.service.ClientService;
import org.springframework.stereotype.Controller;

@Controller
public class ChangeNicknameController {
    DBConn DBconn = new DBConn();
    ClientService uService = new ClientService();
    Client client = new Client();
}
