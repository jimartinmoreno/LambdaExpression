package com.modernjava.streams.terminal.collectors.comparing;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class CollectorsMinMaxExample {
    public static void main(String[] args) {
        //instructor with minimum years of experience
        Optional<Instructor> instructor = Instructors.getAll().stream()
                .collect(Collectors.minBy(Comparator.comparing(
                        Instructor::getYearsOfExperience)));
        out.println("instructor minBy = " + instructor);
        out.println("---------------");

        instructor = Instructors.getAll().stream()
                .min(Comparator.comparing(Instructor::getYearsOfExperience));
        out.println("instructor min = " + instructor);
        instructor = Instructors.getAll().stream()
                .sorted(Comparator.comparing(Instructor::getYearsOfExperience)).findFirst();
        out.println("instructor sorted findFirst min = " + instructor);

        out.println("---------------");
        instructor = Instructors.getAll().stream()
                .collect(Collectors.maxBy(Comparator.comparing(
                        Instructor::getYearsOfExperience)));
        out.println("instructor maxBy = " + instructor);


        instructor = Instructors.getAll().stream()
                .max(Comparator.comparing(Instructor::getYearsOfExperience));
        out.println("instructor max = " + instructor);

        instructor = Instructors.getAll().stream()
                .sorted(Comparator.comparing(Instructor::getYearsOfExperience).reversed()).findFirst();
        out.println("instructor sorted comparing findFirst max = " + instructor);
    }
}
