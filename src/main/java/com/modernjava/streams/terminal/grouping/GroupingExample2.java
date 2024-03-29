package com.modernjava.streams.terminal.grouping;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class GroupingExample2 {
    public static void main(String[] args) {
        //grouping by length of string and also checking that the names contains e
        //and only return those name which has e in it
        List<String> name = List.of("Sid", "Mike", "Jenny", "Gene", "Rajeev");
        Map<Integer, List<String>> result = name.stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.filtering(s -> s.contains("e"), Collectors.toList())));

        out.println("result = " + result);
        result = name.stream()
                .filter(s -> s.contains("e"))
                .collect(Collectors.groupingBy(String::length, Collectors.toList()));

        out.println("result = " + result);

        out.println("------------------");

        //instructor grouping them by Senior(>10) and Junior(<10) and filter them
        //on online courses
        Map<String, List<Instructor>> instructorByExpAndOnline = Instructors.getAll()
                .stream().collect(Collectors.groupingBy(instructor ->
                                instructor.getYearsOfExperience() > 10 ? "SENIOR" : "JUNIOR",
                        Collectors.filtering(Instructor::isOnlineCourses, Collectors.toList())));

        instructorByExpAndOnline.forEach((key, value) -> {
            out.println("key  = " + key + " value = " + value);
        });

        instructorByExpAndOnline = Instructors.getAll().stream()
                .filter(Instructor::isOnlineCourses)
                .collect(Collectors.groupingBy(instructor ->
                                instructor.getYearsOfExperience() > 10 ? "SENIOR" : "JUNIOR",
                                Collectors.toList()));

        instructorByExpAndOnline.forEach((key, value) -> {
            out.println("key  = " + key + " value = " + value);
        });
    }
}
