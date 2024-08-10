package com.Shop.Cart;

import com.Shop.Product.Product;

import java.util.List;

public interface ICart {
    List<Product> getProducts();
    void addProduct();
    void removeProduct();
}
