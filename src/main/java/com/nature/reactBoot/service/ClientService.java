package com.nature.reactBoot.service;

import com.nature.reactBoot.database_connection.DBConn;
import com.nature.reactBoot.model.Client;
import com.nature.reactBoot.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientService {
    DBConn DBconn;
    Connection conn = null;
    PreparedStatement pstmt = null;




    public void insertClient(Client client) {
        try {
            DBconn = new DBConn();
            conn = DBconn.connect();
            System.out.println("service :: " + client.getClient_id());
            String sql = "insert into client_information(client_id, client_password, client_nickname, client_email, client_phone, client_secession) values (?,?,?,?,?, '0')";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, client.getClient_id());
            pstmt.setString(2, client.getClient_password());
            pstmt.setString(3, client.getClient_nickname());
            pstmt.setString(4, client.getClient_email());
            pstmt.setString(5, client.getClient_phone());
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
    public int logIn(Login login){
        int rtn = 0;
        try{
            String result = "";
            DBconn = new DBConn();
            conn = DBconn.connect();
            String id = login.getClient_id();
            String pw = login.getClient_password();
            String sql = "select client_id from client_information where client_id =\"" + id + "\""+ "and client_password =\"" + pw + "\";";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

//        ArrayList<String> contain = new ArrayList<String>();

            String rst = "";

            while(rs.next()) {
                System.out.println(rs.getString(1));

                rst = rs.getString(1);

//            contain.add(rs.getString(1));
            }
            if (rst.equals(id)) {
                rtn = 0;
            } else{
                rtn = 1;
            }
        }catch(Exception e){
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

        return rtn;
    }
    public void changePassword(Client client) {
        try {
            String sql = "update client_information set client_password = (?) where client_id = (?) and client_password = (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, client.getClient_password());
            pstmt.setString(2, client.getClient_id());
            pstmt.setString(3, client.getClient_password());
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
    public void changeNickname(Client client){
        try{
            String sql = "update client_information set client_nickname = (?) where client_id = (?) and client_password = (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, client.getClient_nickname());
            pstmt.setString(2, client.getClient_id());
            pstmt.setString(3, client.getClient_password());
            pstmt.executeUpdate();
        } catch(Exception e){
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
    public void deleteClient(Client client){
        try{
            String sql = "update client_information set client_secession = 'o' where client_id = (?)";
            pstmt.setString(1, client.getClient_id());
            pstmt.executeUpdate();
        } catch(Exception e){
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
