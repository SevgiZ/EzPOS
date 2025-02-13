package com.main.ezpos;

public class ScannedItem {
    private String name;
    private double discount;
    private double price;

    public ScannedItem(String name, double discount, double price) {
        this.name = name;
        this.discount = discount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

