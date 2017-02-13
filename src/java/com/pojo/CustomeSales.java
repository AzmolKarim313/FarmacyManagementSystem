/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

/**
 *
 * @author Azmol-IT
 */
public class CustomeSales {
    
    private int cus_id;
    private String cus_name;
    private String cus_contact;
    private String cus_email;
    private int saleQuantity; 
    private float sale_price;
    private float due_price;
    private String sale_status;

    public CustomeSales() {
    }

    public CustomeSales(int cus_id) {
        this.cus_id = cus_id;
    }

    public CustomeSales(int cus_id, String cus_name, String cus_contact, String cus_email, int saleQuantity, float sale_price, float due_price, String sale_status) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_contact = cus_contact;
        this.cus_email = cus_email;
        this.saleQuantity = saleQuantity;
        this.sale_price = sale_price;
        this.due_price = due_price;
        this.sale_status = sale_status;
    }

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_contact() {
        return cus_contact;
    }

    public void setCus_contact(String cus_contact) {
        this.cus_contact = cus_contact;
    }

    public String getCus_email() {
        return cus_email;
    }

    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    public int getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public float getSale_price() {
        return sale_price;
    }

    public void setSale_price(float sale_price) {
        this.sale_price = sale_price;
    }

    public float getDue_price() {
        return due_price;
    }

    public void setDue_price(float due_price) {
        this.due_price = due_price;
    }

    public String getSale_status() {
        return sale_status;
    }

    public void setSale_status(String sale_status) {
        this.sale_status = sale_status;
    }
    
}
