package com.Shop.Manager;

import com.Shop.CertainShop.CertainShop;
import com.Shop.Product.Product;

public interface IManager {
    int getId();
    String getName();
    String getEmail();
    String getPassword();
    void manageProducts(CertainShop shop, Product product, String action);

}
