package com.akarsh.functionalprogramming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalProgramming1 {
    public static void main(String[] args) {
        printAllNumbersStructured(List.of(12,3,4,5,6,1,2,3));
        System.out.println("--------------------------------------");
        printAllNumbersFunctional(List.of(12,3,4,5,6,1,2,3));

        System.out.println("--------------------------------------");


        printAllEvenNumbersStructured(List.of(12,3,4,5,6,1,2,3));
        System.out.println("--------------------------------------");
        printAllEvenNumbersFunctional(List.of(12,3,4,5,6,1,2,3));

        System.out.println("--------------------------------------");

        printSquaresOfEvenNumbersFunctional(List.of(12,3,4,5,6,1,2,3));

        System.out.println(collectStringStartingWithN(List.of("Nan", "Null", "Ak", "aku", "nan", "null", "Nanna", "nanna")));

    }

    private static void printSquaresOfEvenNumbersFunctional(List<Integer> integers) {
//        integers
//                .stream()
//                .filter(integer -> integer%2 == 0)
//                .map(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) {
//                        return integer * integer;
//                    }
//                })
//                .forEach(System.out::println);

        integers
                .stream()
                .filter(integer -> integer%2 == 0)
                .mapToInt(integer -> integer * integer)
                .forEach(System.out::println);

    }


    private static void printAllNumbersFunctional(List<Number> numbers) {

//        numbers.forEach(new Consumer<Number>() {
//            @Override
//            public void accept(Number number) {
//                 System.out.println(number);
//            }
//        });

//        numbers.forEach(number -> System.out.println(number));

        numbers.forEach(System.out::println);
    }

    private static void printAllNumbersStructured(List<? extends Number> numbers) {
        for(Number x: numbers) System.out.println(x);
    }

    private static void printAllEvenNumbersFunctional(List<Integer> integers) {
//        integers.forEach(num -> {
//            if(num%2==0) System.out.println(num);
//        });

        integers
                .stream()
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        System.out.println("Before filtering");
                        return integer%2==0;
                    }
                })
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println("Before consuming");
                        System.out.println(integer);
                    }
                });

        integers
                .stream()
                .filter(integer -> integer%2==0)
                .forEach(System.out::println);

    }

    private static void printAllEvenNumbersStructured(List<Integer> numbers) {
        for(Integer x: numbers)
            if( x%2 ==0)
                System.out.println(x);
    }



    private static List<String> collectStringStartingWithN(List<String> names){
        return names.stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());
    }
}