package com.modernjava.streams.terminal.collectors;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.stream.Collectors;

import static java.lang.System.*;

public class CollectorSummingAveragingExample {
    public static void main(String[] args) {
        //sum of years of experience of all instructor
        int sum = Instructors.getAll().stream()
                .collect(Collectors.summingInt(Instructor::getYearsOfExperience));

        out.println("sum = " + sum);

        sum = Instructors.getAll().stream()
                .mapToInt(Instructor::getYearsOfExperience).sum();

        out.println("sum = " + sum);

        //calculate average of years of experience of all instructors
        double average = Instructors.getAll().stream()
                .collect(Collectors.averagingInt(Instructor::getYearsOfExperience));

        out.println("average = " + average);

        average = Instructors.getAll().stream()
                .mapToInt(Instructor::getYearsOfExperience).average().getAsDouble();

        out.println("average = " + average);
    }
}