package com.modernjava.streams.collectors_comparators;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsMinMaxExample {
    public static void main(String[] args) {
        //instructor with minimum years of experience
        Optional<Instructor> instructor = Instructors.getAll().stream()
                .collect(Collectors.minBy(Comparator.comparing(
                        Instructor::getYearsOfExperience)));
        System.out.println("instructor minBy = " + instructor);
        System.out.println("---------------");

        instructor = Instructors.getAll().stream()
                .min(Comparator.comparing(Instructor::getYearsOfExperience));
        System.out.println("instructor min = " + instructor);
        instructor = Instructors.getAll().stream()
                .sorted(Comparator.comparing(Instructor::getYearsOfExperience)).findFirst();
        System.out.println("instructor min = " + instructor);

        System.out.println("---------------");
        instructor = Instructors.getAll().stream()
                .collect(Collectors.maxBy(Comparator.comparing(
                        Instructor::getYearsOfExperience)));
        System.out.println("instructor maxBy = " + instructor);
        System.out.println("---------------");

        instructor = Instructors.getAll().stream()
                .max(Comparator.comparing(Instructor::getYearsOfExperience));
        System.out.println("instructor max = " + instructor);

        instructor = Instructors.getAll().stream()
                .sorted(Comparator.comparing(Instructor::getYearsOfExperience).reversed()).findFirst();
        System.out.println("instructor max = " + instructor);


    }
}
