/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.util.Date;

/**
 *
 * @author Azmol-IT
 */
public class Medicin {
    
    private int medicin_id;
    private String medicin_name;
    private String group_name;
    private String company;
    private int quantity;
    private float mrp_rate;
    private Date puchase_date;
    private Date manu_date;
    private Date exp_date;
    private String from_whose;

    public Medicin() {
    }

    public Medicin(int medicin_id) {
        this.medicin_id = medicin_id;
    }

    public Medicin(int medicin_id, String medicin_name, String group_name, String company, int quantity, float mrp_rate, Date puchase_date, Date manu_date, Date exp_date, String from_whose) {
        this.medicin_id = medicin_id;
        this.medicin_name = medicin_name;
        this.group_name = group_name;
        this.company = company;
        this.quantity = quantity;
        this.mrp_rate = mrp_rate;
        this.puchase_date = puchase_date;
        this.manu_date = manu_date;
        this.exp_date = exp_date;
        this.from_whose = from_whose;
    }

    public int getMedicin_id() {
        return medicin_id;
    }

    public void setMedicin_id(int medicin_id) {
        this.medicin_id = medicin_id;
    }

    public String getMedicin_name() {
        return medicin_name;
    }

    public void setMedicin_name(String medicin_name) {
        this.medicin_name = medicin_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getMrp_rate() {
        return mrp_rate;
    }

    public void setMrp_rate(float mrp_rate) {
        this.mrp_rate = mrp_rate;
    }

    public Date getPuchase_date() {
        return puchase_date;
    }

    public void setPuchase_date(Date puchase_date) {
        this.puchase_date = puchase_date;
    }

    public Date getManu_date() {
        return manu_date;
    }

    public void setManu_date(Date manu_date) {
        this.manu_date = manu_date;
    }

    public Date getExp_date() {
        return exp_date;
    }

    public void setExp_date(Date exp_date) {
        this.exp_date = exp_date;
    }

    public String getFrom_whose() {
        return from_whose;
    }

    public void setFrom_whose(String from_whose) {
        this.from_whose = from_whose;
    }
    
}
