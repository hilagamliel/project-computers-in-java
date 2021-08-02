/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author user1
 */
public class Model {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModelPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        HardwareProduct Hard1 = new HardwareProduct(2,888l, "HardThinkped1", "good", 2000);
        HardwareProduct Hard2 = new HardwareProduct(3, 666l, "HardThinkped2", "verygood", 3000);
        //System.out.println(Hard1.toString());
        //System.out.println(Hard1.toString());
        SoftwareProduct Soft1 = new SoftwareProduct(4, 993l, "SoftThinkped1", "good", 2000);
        SoftwareProduct Soft2 = new SoftwareProduct(5, 455l, "SoftThinkped2", "verygood", 3000);
        //System.out.println(Soft1.toString());
        //System.out.println(Soft1.toString());
        Customers customer1 = new Customers(20552l, "hila", "remez");
        Customers customer2 = new Customers(2145l, "tamar", "pardo");
        //System.out.println(customer1.toString());
        //System.out.println(customer2.toString());
        List<Products> ListProduct = new ArrayList<Products>() ;
        ListProduct.add(Soft2);
        ListProduct.add(Soft1);
        ListProduct.add(Hard1);

        PurchaseOrder purchaseOrder = new PurchaseOrder(customer1, ListProduct, LocalDate.now());
        //purchaseOrder.getProductsList().add(Hard1);
        System.out.println(purchaseOrder.toString());

        em.persist(Hard1);
        em.persist(Hard2);
        em.persist(Soft1);
        em.persist(Soft2);
        em.persist(customer1);
        em.persist(customer2);
        em.persist(purchaseOrder);
        HashSet<Products> Products = new HashSet<>();
        em.getTransaction().commit();
        List resultList = em.createQuery("SELECT A FROM Products A").getResultList();
        for (Object object : resultList) {
            System.out.println(object);
        }
        Products.addAll(resultList);
        
        em.close();
    }

}
