package com.modernjava.streams.intermediate.filter;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;

import static java.lang.System.out;

public class StreamsOperations {
    public static void main(String[] args) {
        //count && distinct
        Long count = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .count();

        out.println(count);

        //distinct && sorted by natural order
        List<String> courses = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .toList();
                //.collect(Collectors.toList());
        out.println(courses);

        //filter all courses which not start with "J", anymatch, allmatch and nonematch
        boolean match = Instructors.getAll().stream()
                .map(Instructor::getCourses) // Devuelve la lista de cursos de cada instructor
                .flatMap(List::stream)  // Devuelve un stream a partir de todas las listas  de cursos de
                                        // todos los instructores
                .filter(s -> !s.startsWith("J"))
                .noneMatch(s -> s.startsWith("J"));

        out.println(match);

        match = Instructors.getAll().stream()
                .flatMap(instructor -> instructor.getCourses().stream())
                .filter(s -> !s.startsWith("J"))
                .noneMatch(s -> s.startsWith("J"));

        out.println(match);
    }
}
