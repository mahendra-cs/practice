package com.company.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Cat cat;

    public static void main(String[] args) {
        Printer<Integer> integerPrinter = new Printer<>(21);
        integerPrinter.print();

        Printer<Double> doublePrinter = new Printer<>(21.4);
        doublePrinter.print();

        AnimalPrinter<Cat> catAnimalPrinter = new AnimalPrinter<>(new Cat());
        catAnimalPrinter.print();

        genericMethod(new Cat(), new Dog());

        List<Integer> integerList = new ArrayList<>();
        integerList.add(32);

        printObjects(integerList);

        List<Cat> catList = new ArrayList<>();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        catList.add(cat1);
        catList.add(cat2);

        printObjects(catList);

    }

    private static <T, V> void genericMethod(T thingToPrint, V otherThingToPrint){
        System.out.println("printing from generic method. Object passed is "+thingToPrint.getClass().getSimpleName());
        System.out.println("printing from generic method. Object passed is "+otherThingToPrint.getClass().getSimpleName());
    }

    private static void printObjects(List<?> list){

        list.forEach(x -> {
            System.out.println(x.getClass());
        });
    }
}
