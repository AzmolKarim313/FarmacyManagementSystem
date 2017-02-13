/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Account;
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
public class AccountDAO {

    ConnectionManager conObj;
    Connection conn;
    PreparedStatement pstm;

    public boolean injectAccInfo(int medicin_id, float mrp_price, float sale_price, String status) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "insert into account_info(medicin_id, mrp_price, sale_price, pro_status) values(?,?,?,?)";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, medicin_id);
            pstm.setFloat(2, mrp_price);
            pstm.setFloat(3, sale_price);
            pstm.setString(3, status);
            n = pstm.executeUpdate();
        } catch (Exception e) {
        }
        return n > 0;
    }

    public List<Account> retriveAccInfo() {
        List<Account> listOfAcc = new ArrayList<Account>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select m.medicin_name, a.mrp_price, a.sale_price, a.pro_status\n"
                    + "from account_info a inner join medicin_info m\n"
                    + "ON a.medicin_id = m.medicin_id";
            pstm = conn.prepareStatement(stm);
            rs = pstm.executeQuery();
            while(rs.next()){
                Account acc = new Account();
                acc.setPro_status(rs.getString("pro_status"));
                listOfAcc.add(acc);
            }
        } catch (Exception e) {
        }
        return listOfAcc;
    }

}
