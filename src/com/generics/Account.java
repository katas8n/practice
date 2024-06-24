package com.generics;

public class Account <T, Y> {
    private T id;
    private Y sum;

    Account(T id, Y sum) {
        this.id = id;
        this.sum = sum;
    }

    public Y getSum() {
        return sum;
    }

    public T getId() {
        return id;
    }

    public void setSum(Y sum) {
        this.sum = sum;
    }
}
