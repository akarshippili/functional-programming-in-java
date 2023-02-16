package com.akarsh.functionalprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class Usecase {

    static List<Integer> function1(List<Integer> list){
        return list.stream().sorted().filter(o -> o%2==0).toList();
    }

    static void function2(Map<Integer, String> map){
        System.out.println(map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey)).toList());
        System.out.println(map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).toList());

        Map<Integer, String> result = map.entrySet()
                .stream()
                .filter(a -> a.getValue().length()<5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(result);
    }


    public static void main(String[] args) {
        System.out.println(function1(Arrays.asList(1,2,-3,100,21,-7)));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "akarsh");
        map.put(2, "aku");
        map.put(3, "abhi");
        map.put(4, "tarun");
        map.put(5, "aaabbbccc");

        function2(map);

    }
}
