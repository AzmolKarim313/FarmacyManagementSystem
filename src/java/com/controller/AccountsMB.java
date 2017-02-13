/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.AccountDAO;
import com.pojo.Account;
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
public class AccountsMB {

    Account account = new Account();
    AccountDAO dbAccount;
    
    List<Account> listOfAccDetail = new ArrayList<>();
    
    /**
     * Creates a new instance of AccountsMB
     */
    public AccountsMB() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Account> getListOfAccDetail() {
        dbAccount = new AccountDAO();
        return dbAccount.retriveAccInfo();
    }

    public void setListOfAccDetail(List<Account> listOfAccDetail) {
        this.listOfAccDetail = listOfAccDetail;
    }
    
}
