/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import model.Customers;
import model.Products;
import model.PurchaseOrder;

/**
 *
 * @author user1
 */
public interface Backend {

    void AddCustomer(Customers c) throws Exception;

    void AddProduct(Products c) throws Exception;

    HashMap<Long, Customers> getAllCustomers() throws Exception;

    HashSet<Products> getAllProducts() throws Exception;
    // הוספה של הזמנה למערך ההזמנות (בדומה להוספת לקוח ומוצר.)

    void PlaceOrder(PurchaseOrder po) throws Exception;
    // מחיקה של מוצר ממערך המוצרים, (אין צורך בלולאה.)

    void RemoveProduct(Products c) throws Exception;

    List<PurchaseOrder> getCustomersOrders(Customers c) throws Exception;

    Float CalcProductsTotalCost(Products[] products) throws Exception;

}
