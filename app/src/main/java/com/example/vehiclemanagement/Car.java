package com.example.vehiclemanagement;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;



public class Car {


    boolean sold;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    String name;
    int price;
    String model,condition,engine,year,doors,color,date;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    int image;



    public void setImage(int image) {
        this.image = image;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    Car(String n, int p, boolean s, String model, String condition, String engine, String year, String doors, String color, String date, int image){
        this.name = n;
        this.price = p;
        this.sold = s;
        this.condition = condition;
        this.model = model;
        this.engine = engine;
        this.year = year;
        this.doors = doors;
        this.color = color;
        this.date = date;
        this.image = image;
    }
}
