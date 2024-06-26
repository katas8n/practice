package com.practice;
import com.practice.Entities.*;

import java.util.ArrayList;
import java.util.Scanner;

import static com.practice.Utils.CustomUtils.hasSpecialChar;

public class Main {
    public static void main(String[] args) {
        //     TODO for Bogdan
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Scanner scanner = new Scanner(System.in);

        // **
        Product[] initialSilposProducts = {
                new Product("Pepsi", 13.13),
                new Product("Coca-cola", 23.13, 3.13),
                new Product("Grape", 13.23)
        };

        Store silpo = new Store("Silpo", new ArrayList<Product>());
        Store atb = new Store("atb", new ArrayList<Product>());

        // ** for Bogdan
        String[] specialCharacters = {"!", "@", "#", "$", "%", "ˆ", "&", "*", "(", ")", "+", "?"};
        boolean hasSpecialCharacters = false;

        Store currentStore;

        // ** for Bogdan
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
            System.out.println("Enter what do you wanna do? \na)Registration \nb)Authorisation \nc)Show Products \nd)Store Session \nq)Exit");

            String chosenOption = scanner.nextLine();

            System.out.println("Welcome to the map, please pick the store you want: ");

            // ** to forEach => TODO Dmytro
            for(int i = 0; i < stores.length; i++) {
                System.out.println(i + ") " + stores[i].getTitle());
            }

            System.out.println("Enter the index of store: ");
            String chosenStore = scanner.nextLine();

            currentStore = stores[Integer.parseInt(chosenStore)];


            switch (chosenOption.trim().toLowerCase()) {
                case "a":
                    boolean isInvalid = true;
                    while(isInvalid) {
                        System.out.println("Enter ur name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter ur email: ");
                        String email = scanner.nextLine();
                        System.out.println("Enter ur password: ");

                        String password = scanner.nextLine();

                        boolean commonConditions = name.length() < 2 || email.length() < 5 || !email.contains("@");

                        if(commonConditions || !hasSpecialChar(specialCharacters, password)) continue;

                        Customer customer = new Customer(name, email, password, new Cart(new ArrayList<Product>(),1313), new Wallet("$"));
                        customers.add(customer);

                        isInvalid = false;

                    }

                    System.out.println("The customer was successfully added to the array. [ARRAYS_DATA] : ");
                    for(Customer currentCustomer : customers) {
                        System.out.printf("%s", currentCustomer.getName() + "\n");
                        System.out.println("__________________");
                    }
                    System.out.println("_________________");

                    break;
                case "b":
                    System.out.println("Enter ur email: ");

                    String authEmail = scanner.nextLine();
                    String authPassword = scanner.nextLine();

                    for (int i = 0; i < customers.size(); i++) {
                        Customer currentCustomer = customers.get(i);
                        boolean isValidPassword = authPassword.equals(currentCustomer.getPassword());
                        boolean isValidEmail = authEmail.equals(currentCustomer.getEmail());
                        if(isValidEmail && isValidPassword) {
                            System.out.println("Successfully authenticated");
                        }
                    }
                    break;
                case "c":
                    System.out.println("Show Products");
                    System.out.println(currentStore.getProducts());
                    break;
                case "d":
                    System.out.println("Store Session");

                    break;
                case "q":
                    System.out.println("Exit");
                    isRunning = false;
                    break;
            }
        }



    }
}