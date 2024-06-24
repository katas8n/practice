package com.practice.Utils;

import com.practice.Entities.Cart;
import com.practice.Entities.Customer;

public class CustomUtils {
    public static boolean payFor() {
        if(Customer.getAmountOfUsers() == Cart.getAmountOfCarts()) { return true; }

        return false;
    }

   public static boolean hasSpecialChar(String[] specialCharacters, String value) {
        boolean hasSpecialCharacters = false;

       for(int i = 0; i < specialCharacters.length; i++) {
           String character = specialCharacters[i];

           if(value.contains(character)) hasSpecialCharacters = true;
       }

       return hasSpecialCharacters;
   }
}
