package com.company.designPatterns.decorator;

public class PizzaShop {
    public static void main(String[] args) {
        FarmHouse farmHouse = new FarmHouse();
        BasePizza pizza = new ExtraCheese(new Mushrooms(new FarmHouse()));
        System.out.println(pizza.cost());
    }
}
