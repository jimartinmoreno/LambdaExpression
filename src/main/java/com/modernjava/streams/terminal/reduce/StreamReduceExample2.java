package com.modernjava.streams.terminal.reduce;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Comparator;
import java.util.Optional;

public class StreamReduceExample2 {
    public static void main(String[] args) {
        //printing the instructor who has the highest years of experience
        Optional instructor = Instructors.getAll().stream()
                .reduce((s1, s2) -> s1.getYearsOfExperience()
                        > s2.getYearsOfExperience() ? s1 : s2);
        if (instructor.isPresent())
            System.out.println(instructor.get());

        Optional result = Instructors.getAll().stream().max(Comparator.comparingInt(Instructor::getYearsOfExperience));
        if (result.isPresent())
            System.out.println(instructor.get());

    }
}
