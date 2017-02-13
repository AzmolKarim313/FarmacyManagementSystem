/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author Azmol-IT
 */
public class Calculation {
    
    public float commissionMedicin(int amount, float percentage){
        return (float) amount*percentage;
    }
    
    public String proStatus(float purchase_price, float sale_price){
        float avg = (1 - (sale_price/purchase_price));
        if (avg > 0) {
            return "Profit";
        } else {
            return "Loss";
        }
    }
    
}
