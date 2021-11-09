package com.modernjava.streams.terminal.grouping;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class GroupingMinMaxAvgExample {
    public static void main(String[] args) {
        //grouping the instructors in two sets of online course vs not online
        //and get the max years of experience of the instructors
        Map<Boolean, Optional<Instructor>> maxInstructors = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.maxBy(Comparator.comparing(Instructor::getYearsOfExperience))));

        maxInstructors.forEach((key, value) -> out.println("key = " + key + " value = " + value));

        out.println("---------");

        //collectingAndThen
        Map<Boolean, Instructor> maxInstructors1 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Instructor::getYearsOfExperience)),
                                Optional::get)));

        maxInstructors1.forEach((key, value) -> out.println("key = " + key + " value = " + value));

        out.println("---------");

        Map<Boolean, String> maxInstructorsName = maxInstructors1.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getName()));
        maxInstructorsName.forEach((key, value) -> out.println("key = " + key + " value = " + value));

        out.println("---------");

        Map<Boolean, String> maxInstructorsName2 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Instructor::getYearsOfExperience)),
                                ints -> ints.get().getName())));

        maxInstructorsName2.forEach((key, value) -> out.println("key = " + key + " value = " + value));

        out.println("---------");

        maxInstructors1 = Instructors.getAll().stream()
                .collect(Collectors.toMap(Instructor::isOnlineCourses,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Instructor::getYearsOfExperience))));

        maxInstructors1.forEach((key, value) -> out.println("key = " + key + " value = " + value));

        //average years of experience of instructors who teaches online or not
        out.println("---------");
        Map<Boolean, Double> maxInstructors2 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.averagingInt(Instructor::getYearsOfExperience)));

        maxInstructors2.forEach((key, value) ->
                out.println("key = " + key + " value = " + value));

        //drive a statistical summary from properties of grouped items
        out.println("---------");

        Map<Boolean, IntSummaryStatistics> maxInstructors3 = Instructors.getAll()
                .stream().collect(Collectors.groupingBy(Instructor::isOnlineCourses,
                        Collectors.summarizingInt(Instructor::getYearsOfExperience)
                ));
        out.println("---------");
        maxInstructors3.forEach((key, value) ->
                out.println("key = " + key + " value = " + value));
    }
}
