package com.akarsh.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorExample {
    public static void main(String[] args) {
        Person greg = new Person(23, "greg");
        List<Person> persons = Arrays.asList(
                new Person(21, "john"),
                new Person(22, "sara"),
                new Person(22, "jane"),
                greg,
                greg
        );


        List<Person> personsOlderThan21 = new ArrayList<>();
        persons
                .stream()
                .filter(person -> person.getAge() > 21)
                .forEach(personsOlderThan21::add);

        ArrayList<Person> personArrayList = persons.stream().filter(person -> person.getAge() > 21).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(personArrayList);
        System.out.println(persons.stream().filter(person -> person.getAge() > 21).collect(Collectors.toList()));
        System.out.println(persons.stream().filter(person -> person.getAge() > 21).collect(Collectors.toSet()));
        System.out.println(persons.stream().collect(Collectors.groupingBy(Person::getAge)));
        System.out.println(persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList()))));
        System.out.println(persons.stream().collect(Collectors.groupingBy(person -> person.getName().charAt(0), Collectors.maxBy(Comparator.comparing(Person::getAge)))));
    }
}
