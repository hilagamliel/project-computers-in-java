/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author user1
 */
@Entity
public abstract class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id   
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdProduct")
    private Long id;
    private String Name;
    private String Description;
    private float PricePerUnit;

    public Products() {
    }

    public Products(Long Id, String Name, String Description, float PricePerUnit) {
        this.id = Id;
        this.Name = Name;
        this.Description = Description;
        this.PricePerUnit = PricePerUnit;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public float getPricePerUnit() {
        return PricePerUnit;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPricePerUnit(float PricePerUnit) {
        this.PricePerUnit = PricePerUnit;
    }

    @Override
    public String toString() {
        return " The Id:  " + getId() + " ,  Name:  " + getName() + " ,  Description:  "
                + getDescription() + " ,  PricePerUnit:  " + getPricePerUnit();
    }

    public abstract float GetPrice();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public static String toString(List<Products> p) {
        String str = "The Products: ";
        int i = 1;
        for (Products object : p) {
            str += "p_" + i + " { ";
            str += object.toString();
            str += " } ,  ";
            i++;
        }

        return str;
    }
}
