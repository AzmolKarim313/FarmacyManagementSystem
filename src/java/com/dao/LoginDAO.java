/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Login;
import com.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Azmol-IT
 */
public class LoginDAO {

    ConnectionManager conObj;
    Connection conn;
    PreparedStatement pstm;

    // Medicin Information //
    public boolean injectLoginInfo(String login_name, String pwd, String email) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "insert into login_info(name, pass, email) values(?,?,?)";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, login_name);
            pstm.setString(2, pwd);
            pstm.setString(3, email);
            n = pstm.executeUpdate();
        } catch (Exception e) {
        } finally {
            conObj.closeConnection();
        }
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateLoginInfo(String login_name, String pwd, String email) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "update login_info set name = ?, pass = ? where email = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, login_name);
            pstm.setString(2, pwd);
            pstm.setString(3, email);
            n = pstm.executeUpdate();
        } catch (Exception e) {
        } finally {
            conObj.closeConnection();
        }
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteLoginInfo(String email) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "delete from login_info where email = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, email);
            n = pstm.executeUpdate();
        } catch (Exception e) {
        } finally {
            conObj.closeConnection();
        }
        if (n > 0) {
            return true;
        } else {
            return false;
        }
    }

    public List<Login> loginAllInfo() {
        List<Login> lsitOfLogin = new ArrayList<Login>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select * from login_info";
            pstm = conn.prepareStatement(stm);
            rs = pstm.executeQuery();
            while(rs.next()){
                Login login = new Login();
                login.setName(rs.getString("name"));
                login.setPass(rs.getString("pass"));
                login.setEmail(rs.getString("email"));
                lsitOfLogin.add(login);
            }
        } catch (Exception e) {
        }
        return lsitOfLogin;
    }

}
