package com.nature.reactBoot.service;

import com.nature.reactBoot.controller.DBConn;
import com.nature.reactBoot.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserService {
    Connection conn = null;
    PreparedStatement pstmt = null;

    public UserService(DBConn DBconn) {
        this.conn = DBconn.connect();
    }

    public void insertUser(User user) {
        try {
            String sql = "insert into a(user_id) value (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUser_id());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }

        }


    }
}
