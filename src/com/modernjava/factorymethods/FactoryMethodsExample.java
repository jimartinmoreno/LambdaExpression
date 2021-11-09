package com.modernjava.factorymethods;

import java.util.*;

import static java.lang.System.*;

public class FactoryMethodsExample {
    public static void main(String[] args) {
        //How we used to create unmodifiable list pre Java 9
        List<String> names = new ArrayList<>();
        names.add("Syed");
        names.add("Mike");
        names.add("Jenny");
        names = Collections.unmodifiableList(names);
        out.println("names = " + names);

        //factory methods of Java 9
        List<String> names2 = List.of("Syed", "Mike", "Jenny");
        out.println("names2 = " + names2);
        Set<String> set = Set.of("Syed", "Mike", "Jenny");
        out.println("set = " + set);
        Map<String, String> map = Map.of("Grade1", "Syed", "Grade2", "Mike");
        out.println("map = " + map);
        //modify the list. Fails because is an unmodifiable list
        //names2.add("Gene");
        // set= Set.of("Syed", "Syed", "Mike");
        //names2.sort(Comparator.naturalOrder());
        //out.println("names2 = " + names2);
        //names.sort(Comparator.naturalOrder());

        names2 = names2.stream().sorted(Comparator.naturalOrder()).toList();
        out.println("names2 = " + names2);

    }
}
