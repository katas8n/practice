package com.Shop.Product;

public abstract class AbstractProduct implements IProduct {
    protected String title;
    protected int id;
    protected int amount;
    protected double price;

    public AbstractProduct(String title, int id, int amount, double price) {
        this.title = title;
        this.id = id;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int getId() {
       return this.id;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getSalePrice() {
        return 0;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setPrice() {
        this.price = price;
    }
}


class ProductWithSale extends AbstractProduct {
    public ProductWithSale(String title, int id, int amount, double price) {
        super(title, id, amount, price);
    };
}
class ProductWithoutSale extends AbstractProduct {
    public ProductWithoutSale(String title, int id, int amount, double price) {
        super(title, id, amount, price);
    };
}

class ProductAbsent extends AbstractProduct {
    public ProductAbsent(String title, int id, int amount, double price) {
        super(title, id, amount, price);
    };
}