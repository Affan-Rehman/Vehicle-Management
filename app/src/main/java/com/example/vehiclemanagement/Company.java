package com.example.vehiclemanagement;

/**
 * This is okay.
 */
public class Company {

    String name,address;
    String sales;
    int image;

    /**
     *
     * @param image
     */
    public void setImage(int image){
        this.image = image;
    }

    /**
     *
     * @param value
     * @param value1
     * @param sales
     * @param image
     */
    public Company(String value, String value1, String sales, int image) {
        this.name = value;
        this.address = value1;
        this.sales = sales;
        this.image = image;
    }
}
