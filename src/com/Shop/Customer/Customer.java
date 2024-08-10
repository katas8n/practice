package com.Shop.Customer;

import com.Shop.Cart.Cart;

public class Customer implements ICustomer {
    private String name;
    private int money;
    private Cart cart;
    private int id;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getMoney() {
        return 0;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setMoney() {

    }

    @Override
    public Cart getCart() {
        return null;
    }
}
