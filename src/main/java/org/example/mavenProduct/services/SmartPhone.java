package org.example.mavenProduct.services;
public class SmartPhone extends Product {
    private String vendor;

    public SmartPhone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }
}
