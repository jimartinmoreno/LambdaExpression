package com.modernjava.streams.terminal.reduce;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamMapFilterReduceExample {
    public static void main(String[] args) {
        //total years of experience of all the instructors teaching online courses
        int result = Instructors.getAll().stream()
                .filter(Instructor::isOnlineCourses)
                .map(Instructor::getYearsOfExperience)
                .reduce(0, Integer::sum);
        //.reduce(0, (a, b) -> a + b));  //Equivalent approach
        System.out.println(result);

        result = Instructors.getAll().stream()
                .filter(Instructor::isOnlineCourses)
                .mapToInt(Instructor::getYearsOfExperience).sum();
        System.out.println(result);

        List<Integer> listOfYears = Instructors.getAll().stream()
                .filter(Instructor::isOnlineCourses)
                .mapToInt(Instructor::getYearsOfExperience)
                .boxed()// To perform boxing from int to Integer
                .collect(Collectors.toList());
        System.out.println(listOfYears);

        OptionalDouble averageYears = Instructors.getAll().stream()
                .filter(Instructor::isOnlineCourses)
                .mapToInt(Instructor::getYearsOfExperience).average();
        System.out.println(averageYears.getAsDouble());

        Instructors.getAll().stream().filter(Instructor::isOnlineCourses).forEach((i) -> {
                    i.setTitle("New Title");
                }
        );
        Instructors.getAll().forEach(System.out::println);
    }
}