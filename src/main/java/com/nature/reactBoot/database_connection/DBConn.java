package com.nature.reactBoot.database_connection;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
@Configuration
public class DBConn {
    String ip = "localhost";
    String port = "3306";
    String DB_name = "nature";
    String id = "root";
    String pw = "1234";
    String url = "jdbc:mysql://" + ip + ":" + port + "/" + DB_name + "?characterEncoding=UTF-8&serverTimezone=UTC";
    String sql = null;
    Connection conn = null;
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
