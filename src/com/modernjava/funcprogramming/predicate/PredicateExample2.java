package com.modernjava.funcprogramming.predicate;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample2 {

    //all instructor who teaches online
    private static Predicate<Instructor> isOnlineCourses = (i) -> i.isOnlineCourses() == true;
    //instructor experience is >10 years
    private static Predicate<Instructor> hasMoreThan10YearsExperience = (i) -> i.getYearsOfExperience() > 10;

    public static void main(String[] args) {

        // is instructor teaches online
        List<Instructor> instructors = Instructors.getAll();
        instructors.forEach(instructor -> {
            if (isOnlineCourses.test(instructor)) {
                System.out.println(instructor);
            }
        });

        // is instructor teaches online and exprience is > 10 years
        System.out.println("---------------------");
        instructors.forEach(instructor -> {
            if (isOnlineCourses.and(hasMoreThan10YearsExperience).test(instructor)) {
                System.out.println(instructor);
            }
        });
    }
}