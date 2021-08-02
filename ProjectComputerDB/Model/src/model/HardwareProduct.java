/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author user1
 */
@Entity
public class HardwareProduct extends Products implements Serializable{
    
    @Column(name = "WarranyPeriodHard")
    private int intWarrantyPeriod;

    public HardwareProduct() {
    }

    
    public HardwareProduct(int intWarrantyPeriod, Long Id, String Name, String Description, float PricePerUnit) {
        super(Id, Name, Description, PricePerUnit);
        this.intWarrantyPeriod = intWarrantyPeriod;
    }

    @Override
    public float GetPrice() {
       return super.getPricePerUnit()+intWarrantyPeriod;
    }

    public int getIntWarrantyPeriod() {
        return intWarrantyPeriod;
    }

    public void setIntWarrantyPeriod(int intWarrantyPeriod) {
        this.intWarrantyPeriod = intWarrantyPeriod;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString()+"  The intWarrantyPeriod: "+
                getIntWarrantyPeriod();
    }
    
}
