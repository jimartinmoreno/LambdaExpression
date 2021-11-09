package com.modernjava.streams.terminal.collectors;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.stream.Collectors;

import static java.lang.System.out;

public class CountingExample {
    public static void main(String[] args) {
        //count the numbers of instructors who teaches online courses
        //stream.count
        long count = Instructors.getAll().stream()
                .filter(Instructor::isOnlineCourses)
                .count();
        out.println(count);


        //collectors.counting
        count = Instructors.getAll().stream()
                .filter(Instructor::isOnlineCourses)
                .collect(Collectors.counting());
        out.println("count = " + count);

    }
}
