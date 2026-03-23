package com.lld.parkinglot.model;

public class Vehicle {

    private String number;
    private String color;
    private String model;

    public Vehicle(String number, String color, String model) {
        this.number = number;
        this.color = color;
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }
}