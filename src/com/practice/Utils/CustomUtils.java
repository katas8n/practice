package com.practice.Utils;

import com.practice.Entities.Cart;
import com.practice.Entities.Customer;

public class CustomUtils {
    public static boolean payFor() {
        if(Customer.getAmountOfUsers() == Cart.getAmountOfCarts()) { return true; }

        return false;
    }
}
