package com.practice.Entities;

public class Wallet {
    int ID;
    double amountOfMoney;
    String currency;
    public Wallet(String currency) {
        this.ID = (int) Math.ceil(Math.random() * Math.pow(10,7)); // 23.0
        this.amountOfMoney = Math.random() * 500;
        this.currency = currency;

        switch (this.currency) {
            case "$":
                amountOfMoney *= 0.83;
                break;
            case "E":
                amountOfMoney *= 0.93;
                break;
            case "G":
                amountOfMoney *= 0.73;
                break;
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("Wallet was initialized");
        System.out.println("------------------------------------------------------------");
        System.out.println("[AMOUNT_OF_MONEY]: " + this.amountOfMoney + " " + this.currency);
    }

    @Override
    public String toString() {
        return "Wallet:" +
                "ID=" + ID +
                ", amountOfMoney=" + amountOfMoney +
                ", currency='" + currency + '\'';
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }
}
