/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.CustomeSales;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Azmol-IT
 */
public class CustomerSalesDAO {

    ConnectionManager conObj;
    Connection conn;
    PreparedStatement pstm;

    // Customer Information //
    public boolean injectCustomer(int cus_id, String cus_name, String contact, String email) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "insert into cutomer_info values(?,?,?,?)";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, cus_id);
            pstm.setString(2, cus_name);
            pstm.setString(3, contact);
            pstm.setString(4, email);
            n = pstm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            conObj.closeConnection();
        }
        return n > 0;
    }

    public boolean updateCustomer(String cus_name, String cus_email) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "update cutomer_info set cus_name = ? where cus_email = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, cus_name);
            pstm.setString(2, cus_email);
            n = pstm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            conObj.closeConnection();
        }
        return n > 0;
    }

    public boolean deleteCustomer(String cus_email) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "delete from cutomer_info where cus_email = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, cus_email);
            n = pstm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            conObj.closeConnection();
        }
        return n > 0;
    }

    public List<CustomeSales> allCustomerInfo() {
        List<CustomeSales> listOfCusSale = new ArrayList<CustomeSales>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select cus_name, cus_contact, cus_email from cutomer_info";
            pstm = conn.prepareStatement(stm);
            rs = pstm.executeQuery();
            while(rs.next()){
                CustomeSales consumer = new CustomeSales();
                consumer.setCus_name(rs.getString("cus_name"));
                consumer.setCus_contact(rs.getString("cus_contact"));
                consumer.setCus_email(rs.getString("cus_email"));
                listOfCusSale.add(consumer);
            }
        } catch (Exception e) {
        }
        return listOfCusSale;
    }
    
    public List<String> allCustomerInfoEmail() {
        List<String> listOfCusSale = new ArrayList<String>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select cus_email from cutomer_info";
            pstm = conn.prepareStatement(stm);
            rs = pstm.executeQuery();
            while(rs.next()){
                listOfCusSale.add(rs.getString("cus_email"));
            }
        } catch (Exception e) {
        }
        return listOfCusSale;
    }
    
    public CustomeSales allCustomerInfoById(int cus_id) {
        CustomeSales cusId = null;
        List<CustomeSales> listOfCusSale = new ArrayList<CustomeSales>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select cus_name, cus_contact, cus_email from cutomer_info where cus_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, cus_id);
            rs = pstm.executeQuery();
            while(rs.next()){
                CustomeSales consumer = new CustomeSales();
                consumer.setCus_name(rs.getString("cus_name"));
                consumer.setCus_contact(rs.getString("cus_contact"));
                consumer.setCus_email(rs.getString("cus_email"));
                listOfCusSale.add(consumer);
            }
        } catch (Exception e) {
        }
        if (listOfCusSale.size() > 0) {
            cusId = listOfCusSale.get(0);
        }
        return cusId;
    }

    // Sales Information //
    public boolean injectSales(int cus_id, int medicine_id, int reserv, int quantity, float mrp_price, float sale_price) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "insert into sales_details(cus_id, medicin_id, quantity, sale_price) values(?,?,?,?)";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, cus_id);
            pstm.setInt(2, medicine_id);
            pstm.setInt(3, quantity);
            pstm.setFloat(4, sale_price);
            n = pstm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            conObj.closeConnection();
        }
        if (n > 0) {
            MedicineDAO medicin = new MedicineDAO();
            medicin.updateMedicinAfterSale(reserv - quantity, mrp_price - sale_price, medicine_id);
            return true;
        } else {
            return false;
        }
    }

    public List<CustomeSales> saleInfoDetail(String cus_email) {
        List<CustomeSales> listOfCusSale = new ArrayList<CustomeSales>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select c.cus_name, s.quantity, s.sale_price\n"
                    + "from cutomer_info c inner join sales_details s\n"
                    + "ON c.cus_id = s.cus_id\n"
                    + "where c.cus_email =?";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, cus_email);
            rs = pstm.executeQuery();
            while(rs.next()){
                CustomeSales consumer = new CustomeSales();
                consumer.setCus_name(rs.getString("cus_name"));
                consumer.setSaleQuantity(rs.getInt("quantity"));
                consumer.setSale_price(rs.getFloat("sale_price"));
                listOfCusSale.add(consumer);
            }
        } catch (Exception e) {
        }
        return listOfCusSale;
    }

    public static void main(String[] args) {
        CustomerSalesDAO testObj = new CustomerSalesDAO();
        System.out.println(testObj.deleteCustomer("azmol@gmail.com"));;
    }

}
