package com.Shop.Product;

public interface IProduct {
    String getTitle();
    int getId();
    int getAmount();
    double getPrice();
    double getSalePrice();
    void setAmount();
    void setTitle();

    void setAmount(int amount);

    void setTitle(String title);

    void setPrice();
}
