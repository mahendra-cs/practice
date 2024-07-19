package com.company.java.compare;

public class Player {
    int ranking;
    String name;
    int age;

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
