package com.company.java.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        sample();
        filterExamples();

    }

    private static void filterExamples() {
        List<Person> people = Main.getPeople();

        System.out.println("======== Only females ======");
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .map(Person::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("======== Sorted by age ======");
        people.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("======== Are all above age 5 ======");

        boolean allMatch = people.stream()
                .allMatch(x -> x.getAge() > 5);

        System.out.println(allMatch);

        System.out.println("======== Anyone above age 50 ======");

        boolean anyMatch = people.stream()
                .anyMatch(x -> x.getAge() > 50);

        System.out.println(anyMatch);

        System.out.println("======== Person with maximum age ======");

        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        System.out.println("======== Group by gender ======");

        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach(((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        }));

        System.out.println("======== Oldest female ======");

        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName)
                .ifPresent(System.out::println);

        System.out.println("======== Male less then 50 ======");
        people.stream()
                .filter(person -> person.getAge() < 50 && person.getGender().equals(Gender.MALE))
                .map(Person::getName)
                .forEach(System.out::println);

        System.out.println("======== increase age by 10 ======");
        people.stream()
                .reduce((person1, person2) -> {
                    person1.setAge(person1.getAge() + 10);
                    return person1;
                })
                .ifPresent(System.out::println);

        Predicate<Integer> predicate = x -> x > 5;

        List<Integer> list = Arrays.asList(1,2,3,45,6);

        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("Updated List:");
        people.forEach(System.out::println);


        people.stream()
                .filter(x -> x.getGender().equals(Gender.FEMALE))
                .map(Person::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        people.stream()
                .filter(x -> x.getAge() > 20)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static Function<Integer, Integer> function = (t) -> t+10;
    private static List<Person> getPeople(){
        return Arrays.asList(
                new Person("Antonio", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }

    static void sample(){
        String s = "india is my country";
        System.out.println(s.chars().filter(x -> x == 'i').count());

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.forEach(System.out::println);
        list.stream().map(x -> x*5).collect(Collectors.toList()).forEach(System.out::println);

    }
}
