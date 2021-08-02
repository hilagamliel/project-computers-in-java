/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author user1
 */
@Entity
public class PurchaseOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @ManyToOne
    private Customers customer;
    @OneToMany
    private List<Products> productsList;

    private LocalDate orderDate;

    public PurchaseOrder() {
        
    }

    public PurchaseOrder(Customers customer, List<Products> productsList, LocalDate date) {
        this.customer = customer;
        this.productsList = productsList;
        this.orderDate = date;
    }



    public Customers getCustomer() {
        return customer;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public void setProductsList(ArrayList<Products> productsList) {
        this.productsList = productsList;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "In OrderDate:  " + orderDate + "  |  " + customer.toString()
                + "\n\n  | The Order:[  \n"
                + Products.toString(productsList) + " ]";

    }

}
