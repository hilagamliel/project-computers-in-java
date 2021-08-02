/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdCustomer")
    private Long id;


    @Column(name = "NameCustomer")
    private String Name;
    private String Address;

    public Customers() {
    }

    public Customers(Long Id, String Name, String Address) {
        this.id = Id;
        this.Name = Name;
        this.Address = Address;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "The Id: " + getId() + " , \n The Name: " + getName() + " , \n The Address: " + getAddress();
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
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


}
