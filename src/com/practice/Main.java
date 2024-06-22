package com.practice;
import com.practice.Entities.Product;
import com.practice.Entities.Store;
import com.practice.Utils.CustomUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] initialSilposProducts = {
                new Product("Pepsi", 13.13),
                new Product("Coca-cola", 23.13, 3.13),
                new Product("Grape", 13.23)
        };

        Store silpo = new Store("Silpo", new ArrayList<Product>());
        Store atb = new Store("atb", new ArrayList<Product>());

        Store currentStore;
        Store[] stores = {
                silpo,
                atb
        };

        for(Product product : initialSilposProducts) {
            silpo.addNewProduct(product);
        }

        atb.addNewProduct(new Product("Water", 23.23, 2.23));

        boolean isRunning = true;
        boolean hasAuth = false;

        while (isRunning) {
            System.out.println("Welcome to the map, please pick the store you want: ");

            for(int i = 0; i < stores.length; i++) {
                System.out.println(i + ") " + stores[i].getTitle());
            }

            System.out.println("Enter the index of store: ");
            String chosenStore = scanner.nextLine();

            currentStore = stores[Integer.parseInt(chosenStore)];

            System.out.println("Enter what do you wanna do? \na)Registration \nb)Authorisation \nc)Show Products \nd)Store Session \nq)Exit");

            String chosenOption = scanner.nextLine();
            switch (chosenOption.trim().toLowerCase()) {
                case "a":
                    String name = scanner.nextLine();
                    String email = scanner.nextLine();
                    String passowrd = scanner.nextLine();

//                    if() name.length < 2, name has two aa / ii / oo
                    // if() email.length > 5, contain "@"
                    // if() password.length > 5, contain at least on of [["!", "@", "#"], ["$", "%", "ˆ"] ]
                    break;
                case "b":
                    System.out.println("Authorisation");
                    // Invalid password if email exists
                    break;
                case "c":
                    System.out.println("Show Products");
                    System.out.println(currentStore.getProducts());
                    break;
                case "d":
                    System.out.println("Store Session");
                    // Create new Customer
                    break;
                case "q":
                    System.out.println("Exit");
                    isRunning = false;
                    break;
            }
        }



    }
}