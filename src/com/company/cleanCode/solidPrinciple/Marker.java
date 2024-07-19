package com.company.cleanCode.solidPrinciple;


public class Marker {

    private int name;
    private String color;
    private int price;
    private int year;

    public Marker(int name, String color, int price, int year) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.year = year;
    }

    public int getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }


}
