package com.modernjava.streams.intermediate.map;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Collection;

import static java.lang.System.out;

public class MapExample {
    public static void main(String[] args) {
        //return only instructor names from the instructor list
        Collection<String> instructorNames = Instructors.getAll().stream()
                .map(Instructor::getName)
                .map(String::toUpperCase)
                .sorted()
                .toList();
                //.collect(Collectors.toList());

        out.println(instructorNames);
    }
}
