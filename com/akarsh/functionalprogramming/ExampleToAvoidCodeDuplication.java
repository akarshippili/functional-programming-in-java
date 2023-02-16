package com.akarsh.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExampleToAvoidCodeDuplication {
    public static void main(String[] args) {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors =
                Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades =
                Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

        solutionOne(friends, editors, comrades);
        solutionTwo(friends, editors, comrades);
        solutionThree(friends);
        solutionFour(friends);
    }

    private static void solutionOne(List<String> friends, List<String> editors, List<String> comrades) {
        final long countFriendsStartN =
                friends.stream()
                        .filter(name -> name.startsWith("N")).count();
        final long countEditorsStartN =
                editors.stream()
                        .filter(name -> name.startsWith("N")).count();
        final long countComradesStartN =
                comrades.stream()
                        .filter(name -> name.startsWith("N")).count();

        System.out.println(countFriendsStartN + " " + countEditorsStartN + " " + countComradesStartN);
    }

    private static void solutionTwo(List<String> friends, List<String> editors, List<String> comrades) {
        Predicate<String> filterNameStartsWithN = s -> s.startsWith("N");
        final long countFriendsStartN =
                friends.stream()
                        .filter(filterNameStartsWithN).count();
        final long countEditorsStartN =
                editors.stream()
                        .filter(filterNameStartsWithN).count();
        final long countComradesStartN =
                comrades.stream()
                        .filter(filterNameStartsWithN).count();

        System.out.println(countFriendsStartN + " " + countEditorsStartN + " " + countComradesStartN);
    }

    private static void solutionThree(List<String> friends) {
        Predicate<String> filterNameStartsWithN = s -> s.startsWith("N");
        Predicate<String> filterNameStartsWithB = s -> s.startsWith("B");

        final long countFriendsStartN =
                friends.stream()
                        .filter(filterNameStartsWithN).count();
        final long countFriendsStartB =
                friends.stream()
                        .filter(filterNameStartsWithB).count();

        System.out.println(countFriendsStartN + " " + countFriendsStartB);
    }

    private static void solutionFour(List<String> friends) {
        final long countFriendsStartN =
                friends.stream()
                        .filter(getFilterOnLetter("N")).count();
        final long countFriendsStartB =
                friends.stream()
                        .filter(getFilterOnLetter("B")).count();

        System.out.println(countFriendsStartN + " " + countFriendsStartB);
    }

    private static Predicate<String> getFilterOnLetter(String letter) {
        return s -> s.startsWith(letter);
    }

}
