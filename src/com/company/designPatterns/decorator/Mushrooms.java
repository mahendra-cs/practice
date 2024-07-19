package com.company.designPatterns.decorator;

public class Mushrooms extends Toppings{
    BasePizza basePizza;

    public Mushrooms(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 20;
    }
}
