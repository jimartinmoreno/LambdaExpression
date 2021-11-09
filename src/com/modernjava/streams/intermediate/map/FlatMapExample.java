package com.modernjava.streams.intermediate.map;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class FlatMapExample {
    public static void main(String[] args) {
        //Get a list of all the courses the instructors offers

        Set<String> instructorsCoursesSet = Instructors.getAll().stream()
                //.flatMap(instructor -> instructor.getCourses().stream())
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        out.println(instructorsCoursesSet);
    }
}
