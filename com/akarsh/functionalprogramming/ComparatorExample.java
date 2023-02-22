package com.akarsh.functionalprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person(21, "john"),
                new Person(22, "sara"),
                new Person(23, "jane"),
                new Person(24, "greg")
        );

        List<Person> sortedList = persons
                .stream()
                .sorted((o1, o2) -> o1.ageDifference(o2))
                .toList();
        System.out.println(sortedList);

        // same thing can be done using method references
        List<Person> sortedList2 = persons
                .stream()
                .sorted(Person::ageDifference)
                .toList();
        System.out.println(sortedList2);

        // reverse
        List<Person> reverseSortedList = persons
                .stream()
                .sorted((o1, o2) -> o2.ageDifference(o1)) // this can't be done using method references param2.func(param1) for that use reversed as below example
                .toList();
        System.out.println(reverseSortedList);

        Comparator<Person> personComparatorByAge = Person::ageDifference;
        List<Person> reverseSortedList2 = persons
                .stream()
                .sorted(personComparatorByAge.reversed()) // reversed method is a higher order function which take a functions and return a function by reversing the parameters
                .toList();
        System.out.println(reverseSortedList2);

    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int ageDifference(Person p1) {
        return this.age - p1.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}