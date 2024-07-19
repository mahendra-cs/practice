package com.company.java.generics;

import java.io.Serializable;

public class AnimalPrinter <T extends Animal & Serializable>{ // T extends Animal is example of bounded generics and we can
    // extends multiple interfaces and one class
    T thingToPrint;
    public AnimalPrinter(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    void print(){
        thingToPrint.eat();
    }
}
