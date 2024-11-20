package com.legerito.practice.abs.models;

public class Bottle extends ProductForSale{

    private String material;
    private int capacityInMl;

    public Bottle(double price, String material, int capacityInMl) {
        super("Bottle", price, "Container to store liquids.");
        this.material = material;
        this.capacityInMl = capacityInMl;
    }

    @Override
    public void showDetails() {
        System.out.printf("Type : %s, Description : %s, Price : %.2f",getType(), getDescription(), getPrice());
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCapacityInMl() {
        return capacityInMl;
    }

    public void setCapacityInMl(int capacityInMl) {
        this.capacityInMl = capacityInMl;
    }
}
