package com.modernjava.streams.intermediate.filter;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class FilterPeekCollectExample {
    public static void main(String[] args) {
        //creating a map of names and course of instructors who teaches
        //online have more than 10 years of experience

        //Predicate<Instructor> p1 = i -> i.isOnlineCourses();
        Predicate<Instructor> p1 = Instructor::isOnlineCourses;
        Predicate<Instructor> p2 = i -> i.getYearsOfExperience() > 10;

        out.println("--- Peek ---");
        List<Instructor> list = Instructors.getAll();
        /**
         * Peek() Returns a stream consisting of the elements of this stream, additionally performing the
         * provided action on each element as elements are consumed from the resulting stream.
         * This is an intermediate operation.
         */

        list = list.stream()
                .filter(p1)
                .peek(out::println)
                .filter(p2)
				.peek(out::println)
                .toList();
                //.collect(Collectors.toList());

        out.println("--- Collect ---");
        Map<String, List<String>> map = list.stream()
                .filter(p1)
                .filter(p2)
                .collect(Collectors.toMap(Instructor::getName, Instructor::getCourses));

        out.println(map);
    }
}
