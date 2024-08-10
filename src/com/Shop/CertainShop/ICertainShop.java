package com.Shop.CertainShop;

import com.Shop.Customer.Customer;
import com.Shop.Manager.Manager;
import com.Shop.Product.Product;


import java.util.List;

public interface ICertainShop {
    double getMoney();
    int getId();
    List<Product> getProducts();
    List<Manager> getManagers();
    List<Customer> getCustomers();
}
