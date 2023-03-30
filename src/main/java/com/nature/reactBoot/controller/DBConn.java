package com.nature.reactBoot.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
@Configuration
public class DBConn {
    String url = "jdbc:mysql://localhost:3306/test_db?characterEncoding=UTF-8&serverTimezone=UTC";
    String id = "root";
    String pw = "1234";
    String sql = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    public Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("db접속성공");
        }catch (Exception e){
            System.out.println("db접속실패");
            e.printStackTrace();
        }
        return conn;
    }

}
