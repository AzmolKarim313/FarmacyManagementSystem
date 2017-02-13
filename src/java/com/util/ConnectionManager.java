/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Azmol-IT
 */
public class ConnectionManager {
    
    private final String CONN_DRIVER = "com.mysql.jdbc.Driver";
    private final String CONN_SCHEMA = "jdbc:mysql://localhost:3306/farmacy_inventory_db";
    private final String USERNAME = "root";
    private final String PASSWORD = "apcl123456";
    
    private Connection conn;
    
    public Connection doConnection(){
        try {
            Class.forName(CONN_DRIVER);
            conn = DriverManager.getConnection(CONN_SCHEMA, USERNAME, PASSWORD);
        } catch (Exception e) {
            conn = null;
        }
        return conn;
    }
    
    public void closeConnection(){
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    
//    public static void main(String[] args) {
//        ConnectionManager testObj = new ConnectionManager();
//        if (testObj.doConnection().equals("")) {
//            System.err.println("Connection Error");
//        } else {
//            System.out.println("Connection successful");
//        }
//    }
    
}
