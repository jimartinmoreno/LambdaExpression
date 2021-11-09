package com.modernjava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamVsCollectionExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Mike");
        names.add("Syed");
        names.add("Rajeev");
        System.out.println("--------");
        System.out.println(names);

        names.remove("Syed");
        System.out.println("--------");
        System.out.println(names);

        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("--------");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("--------");
        for (String name : names) {
            System.out.println(name);
        }


        Stream<String> namesStream = names.stream();
        System.out.println("--------");
        //Trasversing the collection
        namesStream.forEach(System.out::println);

        /**
         * ERROR: The Treams can only be trasversing once, then the stream is closed
         */
        // namesStream.forEach(System.out::println);

        System.out.println("--------");
        List<String> list2 = names.stream().filter(s -> s.startsWith("M")).collect(Collectors.toList());
        System.out.println(list2);


    }
}
