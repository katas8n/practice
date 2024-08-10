package com.Shop.Customer;

import com.Shop.Cart.Cart;

public interface ICustomer {
    String getName();
    double getMoney();
    int getId();
    void setMoney();
    Cart getCart();
}
