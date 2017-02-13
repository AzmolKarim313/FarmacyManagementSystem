/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.MedicineDAO;
import com.pojo.Medicin;
import java.sql.Date;
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
public class MedicineMB {

    Medicin medicin = new Medicin();
    MedicineDAO dbMedicin;

    List<Medicin> lsitOfAllMedicin = new ArrayList<>();
    List<Integer> lsitOfAllMedicinID = new ArrayList<>();
//    List<Medicin> lsitOfAllMedicinById = new ArrayList<>();
    List<Medicin> lsitOfMedicinPurAllInfo = new ArrayList<>();
    List<Medicin> lsitOfProductDetailByName = new ArrayList<>();
    List<Medicin> lsitOfProductDetailByGroupName = new ArrayList<>();
    List<Medicin> lsitOfMedicinPurAllInfoByMedId = new ArrayList<>();
    List<Medicin> lsitOfMedicinPurAllInfoByPurDate = new ArrayList<>();
    List<Medicin> lsitOfMedicinPurAllInfoByPurDateAndMedID = new ArrayList<>();

    /**
     * Creates a new instance of MedicineMB
     */
    public MedicineMB() {
    }

    public Medicin getMedicin() {
        return medicin;
    }

    public void setMedicin(Medicin medicin) {
        this.medicin = medicin;
    }

    public List<Medicin> getLsitOfAllMedicin() {
        dbMedicin = new MedicineDAO();
        return dbMedicin.medicinAllInfo();
    }

    public void setLsitOfAllMedicin(List<Medicin> lsitOfAllMedicin) {
        this.lsitOfAllMedicin = lsitOfAllMedicin;
    }

    public List<Integer> getLsitOfAllMedicinById() {
        dbMedicin = new MedicineDAO();
        return dbMedicin.medicinAllId();
    }

//    public void setLsitOfAllMedicinById(List<Medicin> lsitOfAllMedicinById) {
//        this.lsitOfAllMedicinById = lsitOfAllMedicinById;
//    }
//    public List<Medicin> getLsitOfAllMedicinID() {
//        dbMedicin = new MedicineDAO();
//        return dbMedicin.medicinAllInfoById(medicin.getMedicin_id());
//    }
    public void setLsitOfAllMedicinID(List<Integer> lsitOfAllMedicinID) {
        this.lsitOfAllMedicinID = lsitOfAllMedicinID;
    }

    public List<Medicin> getLsitOfMedicinPurAllInfo() {
        dbMedicin = new MedicineDAO();
        return dbMedicin.medicinPurAllInfo();
    }

    public void setLsitOfMedicinPurAllInfo(List<Medicin> lsitOfMedicinPurAllInfo) {
        this.lsitOfMedicinPurAllInfo = lsitOfMedicinPurAllInfo;
    }

//    public List<Medicin> getLsitOfMedicinPurAllInfoByMedId() {
//        dbMedicin = new MedicineDAO();
//        return dbMedicin.medicinPurAllInfoByMedId(medicin.getMedicin_id());
//    }

    public void setLsitOfMedicinPurAllInfoByMedId(List<Medicin> lsitOfMedicinPurAllInfoByMedId) {
        this.lsitOfMedicinPurAllInfoByMedId = lsitOfMedicinPurAllInfoByMedId;
    }

    public List<Medicin> getLsitOfMedicinPurAllInfoByPurDate() {
        dbMedicin = new MedicineDAO();
        return dbMedicin.medicinPurAllInfoByPurDate(new java.sql.Date(medicin.getPuchase_date().getDate()));
    }

    public void setLsitOfMedicinPurAllInfoByPurDate(List<Medicin> lsitOfMedicinPurAllInfoByPurDate) {
        this.lsitOfMedicinPurAllInfoByPurDate = lsitOfMedicinPurAllInfoByPurDate;
    }

    public List<Medicin> getLsitOfMedicinPurAllInfoByPurDateAndMedID() {
        dbMedicin = new MedicineDAO();
        return dbMedicin.medicinPurAllInfoByPurDateAndMedID(new java.sql.Date(medicin.getPuchase_date().getDate()), medicin.getMedicin_id());
    }

    public void setLsitOfMedicinPurAllInfoByPurDateAndMedID(List<Medicin> lsitOfMedicinPurAllInfoByPurDateAndMedID) {
        this.lsitOfMedicinPurAllInfoByPurDateAndMedID = lsitOfMedicinPurAllInfoByPurDateAndMedID;
    }

    public List<Medicin> getLsitOfProductDetailByName() {
        dbMedicin = new MedicineDAO();
        return dbMedicin.productDetailByName(medicin.getMedicin_name());
    }

    public void setLsitOfProductDetailByName(List<Medicin> lsitOfProductDetailByName) {
        this.lsitOfProductDetailByName = lsitOfProductDetailByName;
    }

    public List<Medicin> getLsitOfProductDetailByGroupName() {
        dbMedicin = new MedicineDAO();
        return dbMedicin.productDetailByGroupName(medicin.getGroup_name());
    }

    public void setLsitOfProductDetailByGroupName(List<Medicin> lsitOfProductDetailByGroupName) {
        this.lsitOfProductDetailByGroupName = lsitOfProductDetailByGroupName;
    }

    public void insertMedicinInfo() {
        dbMedicin = new MedicineDAO();
        dbMedicin.injectMedicinInfo(medicin.getMedicin_id(), medicin.getMedicin_name(), medicin.getGroup_name(), medicin.getCompany());
    }

    public void insertPurMed() {
        dbMedicin = new MedicineDAO();
        dbMedicin.injectMedicinPurInfo(medicin.getMedicin_id(), medicin.getQuantity(), medicin.getMrp_rate(),
                Date.valueOf("2000-01-01"), Date.valueOf("2000-01-01"), Date.valueOf("2000-01-01"), medicin.getFrom_whose());
    }

    public void insertMedicine() {
        insertMedicinInfo();
        insertPurMed();
    }

    public void fullInfoByID() {
        dbMedicin = new MedicineDAO();
        try {
            Medicin medinfoValue = dbMedicin.medicinAllInfoById(medicin.getMedicin_id());
            Medicin medinfoPurValue = dbMedicin.medicinPurAllInfoByMedId(medicin.getMedicin_id());
            medicin.setMedicin_id(medinfoValue.getMedicin_id());
            medicin.setMedicin_name(medinfoValue.getMedicin_name());
            medicin.setGroup_name(medinfoValue.getGroup_name());
            medicin.setCompany(medinfoValue.getCompany());
            medicin.setQuantity(medinfoPurValue.getQuantity());
            medicin.setMrp_rate(medinfoPurValue.getMrp_rate());
            medicin.setExp_date(medinfoPurValue.getExp_date());
            medicin.setPuchase_date(medinfoPurValue.getPuchase_date());
            medicin.setManu_date(medinfoPurValue.getManu_date());
            medicin.setFrom_whose(medinfoPurValue.getFrom_whose());
        } catch (Exception e) {
        }
    }
    
    public void updateMedInfo(){
        dbMedicin = new MedicineDAO();
        dbMedicin.updateMedicinInfo(medicin.getMedicin_name(), medicin.getGroup_name(), medicin.getCompany(), medicin.getMedicin_id());
    }
    
    public void updateMedPurInfo(){
        dbMedicin = new MedicineDAO();
        dbMedicin.updateMedicinPurInfo(medicin.getQuantity(), medicin.getMrp_rate(), Date.valueOf("2000-01-01"), medicin.getMedicin_id(), medicin.getMedicin_id());
    }
    
    public void deleteMedInfo(){
        dbMedicin = new MedicineDAO();
        dbMedicin.deleteMedicinPurInfo(medicin.getMedicin_id());
        dbMedicin.deleteMedicinInfo(medicin.getMedicin_id());
    }
    

}
