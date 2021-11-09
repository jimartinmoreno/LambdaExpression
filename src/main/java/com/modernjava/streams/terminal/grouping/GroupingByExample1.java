package com.modernjava.streams.terminal.grouping;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class GroupingByExample1 {
    public static void main(String[] args) {
        //group list of name by their length
        List<String> names = List.of("Syed", "Mike", "Jenny", "Gene", "Rajeev");

        Map<Integer, List<String>> result = names.stream()
                .collect(Collectors.groupingBy(String::length));
        out.println("result = " + result);

        out.println("-----------------");

        //grouping by instructors by their gender
        Map<String, List<Instructor>> instructorByGender = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getGender));

        instructorByGender.forEach((key, value) -> out.println("key = " + key + " value = " + value));
        out.println("-----------------");

        //grouping by experience where >10 years of experience is classified
        //as Senior and others are junior
        Map<String, List<Instructor>> instructorsByExperience = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(instructor ->
                        instructor.getYearsOfExperience() > 10 ? "SENIOR" : "JUNIOR"));

        instructorsByExperience.forEach((key, value) ->
                out.println("key = " + key + " value = " + value));

        out.println("-----------------");

        Map<Integer, List<Instructor>> instructorsByYearsExperience = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience));

        instructorsByYearsExperience.forEach((key, value) ->
                out.println("key = " + key + " value = " + value));
    }
}
