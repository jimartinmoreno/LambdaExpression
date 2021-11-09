package com.modernjava.streams.terminal.collectors;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class PartitioningByExample {
    public static void main(String[] args) {
        //  partition instructors in two groups of instructor first is
        //  years of experience is > 10 and other is <=10
        Predicate<Instructor> experiencePredicate = instructor -> instructor.getYearsOfExperience() > 10;

        Map<Boolean, List<Instructor>> partitionMap = Instructors.getAll().stream()
                .collect(Collectors.partitioningBy(experiencePredicate));

        partitionMap.forEach((key, value) -> out.println("key = " + key + " value = " + value));
        out.println("-------------------------------");

        //partition but return is set instead of list
        Map<Boolean, Set<Instructor>> partitionSet = Instructors.getAll().stream()
                .collect(Collectors.partitioningBy(experiencePredicate, Collectors.toSet()));

        partitionSet.forEach((key, value) -> out.println("key = " + key + " value: " + value));
    }
}
