/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Medicin;
import com.util.ConnectionManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Azmol-IT
 */
public class MedicineDAO {

    ConnectionManager conObj;
    Connection conn;
    PreparedStatement pstm;

    // Medicin Information //
    public boolean injectMedicinInfo(int medicine_id, String medicine_name, String group_name, String company_name) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "insert into medicin_info values(?,?,?,?)";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, medicine_id);
            pstm.setString(2, medicine_name);
            pstm.setString(3, group_name);
            pstm.setString(4, company_name);
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

    public boolean updateMedicinInfo(String medicine_name, String group_name, String company_name, int medicin_id) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "update medicin_info set medicin_name = ?, group_name = ?, company = ? where medicin_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, medicine_name);
            pstm.setString(2, group_name);
            pstm.setString(3, company_name);
            pstm.setInt(4, medicin_id);
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

    public boolean deleteMedicinInfo(int medicin_id) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "delete from medicin_info where medicin_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, medicin_id);
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

    public List<Medicin> medicinAllInfo() {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        List<Medicin> listMedicin = new ArrayList<Medicin>();
        try {
            String stm = "select * from medicin_info";
            pstm = conn.prepareStatement(stm);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Medicin obj = new Medicin();
                obj.setMedicin_id(rs.getInt("medicin_id"));
                obj.setMedicin_name(rs.getString("medicin_name"));
                obj.setGroup_name(rs.getString("group_name"));
                obj.setCompany(rs.getString("company"));

                listMedicin.add(obj);
            }
        } catch (Exception e) {
        }
        return listMedicin;
    }

    public Medicin medicinAllInfoById(int medicin_id) {
        Medicin medInfo = null;
        List<Medicin> listMedicin = new ArrayList<Medicin>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select * from medicin_info where medicin_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, medicin_id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Medicin obj = new Medicin();
                obj.setMedicin_id(rs.getInt("medicin_id"));
                obj.setMedicin_name(rs.getString("medicin_name"));
                obj.setGroup_name(rs.getString("group_name"));
                obj.setCompany(rs.getString("company"));

                listMedicin.add(obj);
            }
        } catch (Exception e) {
        }
        if (listMedicin.size() > 0) {
            medInfo = listMedicin.get(0);
        }
        return medInfo;
    }

    public List<Integer> medicinAllId() {
        List<Integer> listOfId = new ArrayList<Integer>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select medicin_id from medicin_info";
            pstm = conn.prepareStatement(stm);
            rs = pstm.executeQuery();
            while (rs.next()) {
                listOfId.add(rs.getInt("medicin_id"));
            }
        } catch (Exception e) {
        }
        return listOfId;
    }

    // Purchase Medicine Information //
    public boolean injectMedicinPurInfo(int medicin_id, int quantity, float mrp_rate, Date puchase_date, Date manu_date, Date exp_date, String from_whose) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "insert into purchas_medicin_details(medicin_id, quantity, "
                    + "mrp_rate, puchase_date, manu_date, exp_date, from_whose) "
                    + "values(?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, medicin_id);
            pstm.setInt(2, quantity);
            pstm.setFloat(3, mrp_rate);
            pstm.setDate(4, puchase_date);
            pstm.setDate(5, manu_date);
            pstm.setDate(6, exp_date);
            pstm.setString(7, from_whose);
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

    public boolean updateMedicinPurInfo(int quantity, float mrp_rate, Date puchase_date, int puchase_id, int medicin_id) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "update purchas_medicin_details set quantity = ?, mrp_rate = ?, puchase_date = ? where medicin_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, quantity);
            pstm.setFloat(2, mrp_rate);
            pstm.setDate(3, puchase_date);
//            pstm.setInt(4, puchase_id);
            pstm.setInt(4, medicin_id);
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

    public boolean updateMedicinAfterSale(int quantity, float mrp_rate, int medicin_id) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "update purchas_medicin_details set quantity = ?, mrp_rate = ? where medicin_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, quantity);
            pstm.setFloat(2, mrp_rate);
            pstm.setInt(3, medicin_id);
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

    public boolean deleteMedicinPurInfo(int medicin_id) {
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        int n = 0;
        try {
            String stm = "delete from purchas_medicin_details where medicin_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, medicin_id);
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

    public List<Medicin> medicinPurAllInfo() {
        List<Medicin> listOfMedicin = new ArrayList<Medicin>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select * from purchas_medicin_details";
            pstm = conn.prepareStatement(stm);
            rs = pstm.executeQuery();
            while(rs.next()){
                Medicin medicin = new Medicin();
                medicin.setMedicin_id(rs.getInt("medicin_id"));
                medicin.setQuantity(rs.getInt("quantity"));
                medicin.setMrp_rate(rs.getFloat("mrp_rate"));
                medicin.setPuchase_date(rs.getDate("puchase_date"));
                medicin.setPuchase_date(rs.getDate("manu_date"));
                medicin.setPuchase_date(rs.getDate("exp_date"));
                medicin.setFrom_whose(rs.getString("from_whose"));
                listOfMedicin.add(medicin);
            }
        } catch (Exception e) {
        }
        return listOfMedicin;
    }

    public Medicin medicinPurAllInfoByMedId(int medicin_id) {
        Medicin medPurValue = null;
        List<Medicin> listOfMedicin = new ArrayList<Medicin>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select * from purchas_medicin_details where medicin_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setInt(1, medicin_id);
            rs = pstm.executeQuery();
            while(rs.next()){
                Medicin medicin = new Medicin();
                medicin.setMedicin_id(rs.getInt("medicin_id"));
                medicin.setQuantity(rs.getInt("quantity"));
                medicin.setMrp_rate(rs.getFloat("mrp_rate"));
                medicin.setPuchase_date(rs.getDate("puchase_date"));
                medicin.setPuchase_date(rs.getDate("manu_date"));
                medicin.setPuchase_date(rs.getDate("exp_date"));
                medicin.setFrom_whose(rs.getString("from_whose"));
                listOfMedicin.add(medicin);
            }
        } catch (Exception e) {
        }
        if (listOfMedicin.size() > 0) {
            medPurValue = listOfMedicin.get(0);
        }
        return medPurValue;
    }

    public List<Medicin> medicinPurAllInfoByPurDate(Date puchase_date) {
        List<Medicin> listOfMedicin = new ArrayList<Medicin>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select * from purchas_medicin_details where puchase_date = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setDate(1, puchase_date);
            rs = pstm.executeQuery();
            while(rs.next()){
                Medicin medicin = new Medicin();
                medicin.setMedicin_id(rs.getInt("medicin_id"));
                medicin.setQuantity(rs.getInt("quantity"));
                medicin.setMrp_rate(rs.getFloat("mrp_rate"));
                medicin.setPuchase_date(rs.getDate("puchase_date"));
                medicin.setPuchase_date(rs.getDate("manu_date"));
                medicin.setPuchase_date(rs.getDate("exp_date"));
                medicin.setFrom_whose(rs.getString("from_whose"));
                listOfMedicin.add(medicin);
            }
        } catch (Exception e) {
        }
        return listOfMedicin;
    }

    public List<Medicin> medicinPurAllInfoByPurDateAndMedID(Date puchase_date, int medicin_id) {
        List<Medicin> listOfMedicin = new ArrayList<Medicin>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select * from purchas_medicin_details where puchase_date = ? and medicin_id = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setDate(1, puchase_date);
            pstm.setInt(2, medicin_id);
            rs = pstm.executeQuery();
            while(rs.next()){
                Medicin medicin = new Medicin();
                medicin.setMedicin_id(rs.getInt("medicin_id"));
                medicin.setQuantity(rs.getInt("quantity"));
                medicin.setMrp_rate(rs.getFloat("mrp_rate"));
                medicin.setPuchase_date(rs.getDate("puchase_date"));
                medicin.setPuchase_date(rs.getDate("manu_date"));
                medicin.setPuchase_date(rs.getDate("exp_date"));
                medicin.setFrom_whose(rs.getString("from_whose"));
                listOfMedicin.add(medicin);
            }
        } catch (Exception e) {
        }
        return listOfMedicin;
    }

    // Join of Medicine and Purchase Table //
    public List<Medicin> productDetailByName(String medicine_name) {
        List<Medicin> listOfMedicin = new ArrayList<Medicin>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select med.medicin_name, med.group_name, pur.quantity, pur.mrp_rate, pur.manu_date, pur.exp_date, med.company\n"
                    + "from medicin_info med\n"
                    + "inner join purchas_medicin_details pur\n"
                    + "on med.medicin_id = pur.medicin_id\n"
                    + "where med.medicin_name = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, medicine_name);
            rs = pstm.executeQuery();
            while(rs.next()){
                Medicin medicin = new Medicin();
                medicin.setMedicin_name(rs.getString("medicin_name"));
                medicin.setGroup_name(rs.getString("group_name"));
                medicin.setQuantity(rs.getInt("quantity"));
                medicin.setMrp_rate(rs.getFloat("mrp_rate"));
                medicin.setManu_date(rs.getDate("manu_date"));
                medicin.setExp_date(rs.getDate("exp_date"));
                medicin.setCompany(rs.getString("company"));
                listOfMedicin.add(medicin);
            }
        } catch (Exception e) {
        }
        return listOfMedicin;
    }

    public List<Medicin> productDetailByGroupName(String group_name) {
        List<Medicin> listOfMedicin = new ArrayList<Medicin>();
        conObj = new ConnectionManager();
        conn = conObj.doConnection();
        ResultSet rs = null;
        try {
            String stm = "select med.medicin_name, med.group_name, pur.quantity, pur.mrp_rate, pur.manu_date, pur.exp_date, med.company\n"
                    + "from medicin_info med\n"
                    + "inner join purchas_medicin_details pur\n"
                    + "on med.medicin_id = pur.medicin_id\n"
                    + "where med.group_name = ?";
            pstm = conn.prepareStatement(stm);
            pstm.setString(1, group_name);
            rs = pstm.executeQuery();
            while(rs.next()){
                Medicin medicin = new Medicin();
                medicin.setMedicin_name(rs.getString("medicin_name"));
                medicin.setGroup_name(rs.getString("group_name"));
                medicin.setQuantity(rs.getInt("quantity"));
                medicin.setMrp_rate(rs.getFloat("mrp_rate"));
                medicin.setManu_date(rs.getDate("manu_date"));
                medicin.setExp_date(rs.getDate("exp_date"));
                medicin.setCompany(rs.getString("company"));
                listOfMedicin.add(medicin);
            }
        } catch (Exception e) {
        }
        return listOfMedicin;
    }

    public static void main(String[] args) {
        MedicineDAO testObj = new MedicineDAO();
        System.out.println(testObj.injectMedicinPurInfo(5, 100, 5000, Date.valueOf("2016-05-12"), Date.valueOf("2016-05-12"), Date.valueOf("2016-05-12"), "Company"));
    }

}
