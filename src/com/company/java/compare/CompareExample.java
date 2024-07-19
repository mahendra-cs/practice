package com.company.java.compare;

import java.util.*;

public class CompareExample {
    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "A.Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        System.out.println("Before Sorting : ");
        footballTeam.forEach(System.out::println);
        footballTeam.sort(Comparator.comparingInt(o -> o.ranking));
        System.out.println("After Sorting by name: ");
        footballTeam.sort(Comparator.comparing(o -> o.name));
        footballTeam.forEach(System.out::println);

        System.out.println("After Sorting ranking: ");
        footballTeam.forEach(System.out::println);
        footballTeam.sort(Comparator.comparingInt(o -> o.age));
        System.out.println("After Sorting by age: ");
        footballTeam.forEach(System.out::println);
        try {

            Map<String, String> map = new HashMap<>();
        } finally {

        }

    }

}
