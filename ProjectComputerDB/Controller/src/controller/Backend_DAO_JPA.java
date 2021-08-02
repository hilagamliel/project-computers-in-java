/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static javax.persistence.Persistence.createEntityManagerFactory;
import javax.persistence.Query;
import model.Customers;
import model.HardwareProduct;
import model.Products;
import model.PurchaseOrder;
import model.SoftwareProduct;
import model.EnumOfComobox;
/**
 *
 * @author student
 */
public class Backend_DAO_JPA implements Backend {

    private EntityManagerFactory emf = null;
    private EntityManager em=null;

    private static Backend_DAO_JPA bdl_singleton;  // המופע היחיד

    public static Backend_DAO_JPA get_bdl_singleton() // הפונקציה שמחזירה את המופע היחיד
    {
        if (bdl_singleton == null) {
            bdl_singleton = new Backend_DAO_JPA();
        }
        return bdl_singleton;
    }

    public Backend_DAO_JPA() {
        Init();
    }

    private void Init() {
        emf = createEntityManagerFactory("ModelPU");
        em = emf.createEntityManager();
    }

    private void Persist(Serializable serializable) {
        em.getTransaction().begin();
        em.persist(serializable);
        try {
            em.getTransaction().commit();
        } catch (Exception e) {
            em.clear();
            throw e;
        }

    }

    @Override
    public void AddCustomer(Customers c) throws Exception {
        Persist(c);
    }

    @Override
    public void AddProduct(Products p) throws Exception {
        Persist(p);
    }

    @Override
    public HashMap<Long, Customers> getAllCustomers() throws Exception {
        HashMap<Long, Customers> AllCustomers = new HashMap<>();
        List resultList = em.createQuery("SELECT C FROM Customers C").getResultList();
        long j=0;
        for (int i=0;i<resultList.size();i++) {
            AllCustomers.put(j++, (Customers) resultList.get(i));
        }
        return AllCustomers;
    }

    @Override
    public HashSet<Products> getAllProducts() throws Exception {
        HashSet<Products> Products = new HashSet<>();
        List resultList = em.createQuery("SELECT P FROM Products P").getResultList();
        Products.addAll(resultList);
        return Products;
    }

    @Override
    public void PlaceOrder(PurchaseOrder po) throws Exception {
       Persist(po);
    }

    @Override
    public void RemoveProduct(Products p) throws Exception {
        Products find = em.find(Products.class, p.getId());
        em.getTransaction().begin();
        em.remove(find);
        em.getTransaction().commit();
    }

    @Override
    public List<PurchaseOrder> getCustomersOrders(Customers c) throws Exception {
        ArrayList<PurchaseOrder> purchaseOrders = new ArrayList<>();
        List resultList = em.createQuery("SELECT O FROM PurchaseOrder O WHERE O.customer.id=:id").
                setParameter("id", c.getId()).getResultList();
        return resultList;

    }

    @Override
    public Float CalcProductsTotalCost(Products[] products) throws Exception {
        Float sum = new Float(0);
        for (int i = 0; i < products.length; i++) {
            sum += products[i].GetPrice();
        }
        return sum;

    }

    @Override
    protected void finalize() throws Throwable {
        em.close();
    }

}
