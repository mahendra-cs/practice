package com.company.java.generics;

public class Printer <T>{
    private T itemToPrint;
    public Printer(T itemToPrint) {
        this.itemToPrint = itemToPrint;
    }

    void print(){
        System.out.println(itemToPrint);
    }
}
