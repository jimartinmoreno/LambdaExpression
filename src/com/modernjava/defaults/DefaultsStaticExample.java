package com.modernjava.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.*;

public class DefaultsStaticExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mike", "Syed", "Jenny", "Gene", "Rajeev");
        Collections.sort(names);
        System.out.println("names = " + names);
        //names.forEach(out::println);

        names.sort(Comparator.naturalOrder());
        out.println("names = " + names);


    }
}
