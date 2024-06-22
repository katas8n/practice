package com.practice.Entities;

public class Customer {
    private static int amountOfUsers = 0;
    private String name;
    private String email;
    private String password;
    private Cart cart;
    private Wallet wallet;


    public Customer (
            String name,
            String email,
            String password,
            Cart cart,
            Wallet wallet
    ) {
        amountOfUsers++;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cart = cart;
        this.wallet = wallet;
    }
    public static int getAmountOfUsers() {
        return amountOfUsers;
    }

    @Override
    public String toString() {
        return "Customer: " +
                "name:'" + name + '\'' +
                ", email:'" + email + '\'' +
                ", password:'" + password + '\'' +
                ", cart:" + cart +
                ", wallet:" + wallet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }
}

