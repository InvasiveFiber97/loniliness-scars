package com.legerito.practice.abs.models;

public abstract class ProductForSale {

    private final String type;
    private final double price;
    private final String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public void getSalesPrice(int quantity) {
        System.out.printf("\nQuantity : %d, Price : %.2f", quantity, quantity * price);
    }

    public void pricedLineItem(int quantity){
        System.out.println("\n" + type + " : " + ", Quantity : " + quantity + ", Price : " + quantity * price);
    }

    public abstract void showDetails();

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
