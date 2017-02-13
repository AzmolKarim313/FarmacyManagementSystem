/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.CustomerSalesDAO;
import com.pojo.CustomeSales;
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
public class CustomerSaleMB {

    CustomeSales consumer = new CustomeSales();
    CustomerSalesDAO dbConsumer;

    List<CustomeSales> listOfAllCustomerInfo = new ArrayList<>();
    List<String> listOfAllCustomerInfoEmail = new ArrayList<>();
    List<CustomeSales> listOfSaleInfoDetail = new ArrayList<>();

    /**
     * Creates a new instance of CustomerSaleMB
     */
    public CustomerSaleMB() {
    }

    public CustomeSales getConsumer() {
        return consumer;
    }

    public List<String> getListOfAllCustomerInfoEmail() {
        dbConsumer = new CustomerSalesDAO();
        return dbConsumer.allCustomerInfoEmail();
    }

    public void setListOfAllCustomerInfoEmail(List<String> listOfAllCustomerInfoEmail) {
        this.listOfAllCustomerInfoEmail = listOfAllCustomerInfoEmail;
    }

    public void setConsumer(CustomeSales consumer) {
        this.consumer = consumer;
    }

    public List<CustomeSales> getListOfAllCustomerInfo() {
        dbConsumer = new CustomerSalesDAO();
        return dbConsumer.allCustomerInfo();
    }

    public void setListOfAllCustomerInfo(List<CustomeSales> listOfAllCustomerInfo) {
        this.listOfAllCustomerInfo = listOfAllCustomerInfo;
    }

    public List<CustomeSales> getListOfSaleInfoDetail() {
        dbConsumer = new CustomerSalesDAO();
        return dbConsumer.saleInfoDetail(consumer.getCus_email());
    }

    public void setListOfSaleInfoDetail(List<CustomeSales> listOfSaleInfoDetail) {
        this.listOfSaleInfoDetail = listOfSaleInfoDetail;
    }

    public void fullInfoCusById() {
        dbConsumer = new CustomerSalesDAO();
        try {
            CustomeSales cusValue = dbConsumer.allCustomerInfoById(consumer.getCus_id());
            consumer.setCus_name(cusValue.getCus_name());
            consumer.setCus_contact(cusValue.getCus_contact());
            consumer.setCus_email(cusValue.getCus_email());
        } catch (Exception e) {
        }
    }

    public void insertCusInfo() {
        dbConsumer = new CustomerSalesDAO();
        dbConsumer.injectCustomer(consumer.getCus_id(), consumer.getCus_name(), consumer.getCus_contact(), consumer.getCus_email());
    }
    
    public void updateCusInfo(){
        dbConsumer = new CustomerSalesDAO();
        dbConsumer.updateCustomer(consumer.getCus_name(), consumer.getCus_email());
    }
    
    public void deleteCusInfo(){
        dbConsumer = new CustomerSalesDAO();
        dbConsumer.deleteCustomer(consumer.getCus_email());
    }
    
    public static void main(String[] args) {
        CustomerSaleMB testObj = new CustomerSaleMB();
        testObj.deleteCusInfo();
    }
    
    public void fullInfosales(){
        dbConsumer = new CustomerSalesDAO();
        List<CustomeSales> saleValues = dbConsumer.saleInfoDetail(consumer.getCus_email());
        for(int i=0; i < saleValues.size(); i++){
            CustomeSales saleVale = saleValues.get(i);
            consumer.setCus_name(saleVale.getCus_name());
            consumer.setSaleQuantity(saleVale.getSaleQuantity());
            consumer.setSale_price(saleVale.getSale_price());
        }
    }

}
