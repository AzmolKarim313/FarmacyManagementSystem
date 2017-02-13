/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.LoginDAO;
import com.pojo.Login;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Azmol-IT
 */
@ManagedBean
@RequestScoped
public class LoginMB {

    Login login = new Login();
    LoginDAO dbLogin;
    
    List<Login> lsitOfLogin = new ArrayList<>();
    
    /**
     * Creates a new instance of LoginMB
     */
    public LoginMB() {
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public List<Login> getLsitOfLogin() {
        dbLogin = new LoginDAO();
        return dbLogin.loginAllInfo();
    }

    public void setLsitOfLogin(List<Login> lsitOfLogin) {
        this.lsitOfLogin = lsitOfLogin;
    }
    
}
