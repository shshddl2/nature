package com.nature.reactBoot.service;

import com.nature.reactBoot.database_connection.DBConn;
import com.nature.reactBoot.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

public class ClientService {
    DBConn DBconn;
    Connection conn = null;
    PreparedStatement pstmt = null;


    public void insertUser(Client client) {
        try {
            DBconn = new DBConn();
            conn = DBconn.connect();
            String sql = "insert into client_information(user_id, user_password, user_nickname, user_email) values (?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, client.getClient_Id());
            pstmt.setString(2, client.getClient_Password());
            pstmt.setString(3, client.getClient_Nickname());
            pstmt.setString(4, client.getClient_Email());
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
    public List<String> call_Client_Id(String client_Id){
        try{
            DBconn = new DBConn();
            conn = DBconn.connect();
            String sql = "select * from client_information where user_id = "
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
        return
    }
    public void changePassword(Client client) {
        try {
            String sql = "update client_information set user_password = (?) where user_id = (?) and user_password = (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, client.getClient_Password());
            pstmt.setString(2, client.getClient_Id());
            pstmt.setString(3, client.getClient_Password());
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
            String sql = "update client_information set user_nickname = (?) where user_id = (?) and user_password = (?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, client.getClient_Nickname());
            pstmt.setString(2, client.getClient_Id());
            pstmt.setString(3, client.getClient_Password());
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
    public void deleteUser(Client client){
        try{
            String sql = "update client_information set user_secession = 'o' where user_id = (?)";
            pstmt.setString(1, client.getClient_Id());
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
