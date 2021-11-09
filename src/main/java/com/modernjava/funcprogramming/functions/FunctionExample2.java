package com.modernjava.funcprogramming.functions;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class FunctionExample2 {
    //Predicate will return true if instructor has online courses
    //static Predicate<Instructor> isOnlineCourses = i -> i.isOnlineCourses() == true;
    static Predicate<Instructor> isOnlineCourses = Instructor::isOnlineCourses;
    static Function<Instructor, Integer> ageFunction = Instructor::getYearsOfExperience;
    //Function which will List<Instructors> and return a Map<String, Integer>
    static Function<List<Instructor>, Map<String, Integer>> mapFunction = (instructors -> {
        Map<String, Integer> map = new HashMap<>();
        instructors.forEach(instructor -> {
            if (isOnlineCourses.test(instructor)) {
                map.put(instructor.getName(), ageFunction.apply(instructor));
            }
        });
        return map;
    });

    public static void main(String[] args) {
        //Map of instructors with name and years of experience who has online courses
        out.println(mapFunction.apply(Instructors.getAll()));

        out.println(Instructors.getAll().stream()
                .filter(Instructor::isOnlineCourses)
                .collect(Collectors.toMap(Instructor::getName, Instructor::getYearsOfExperience))
                );
    }
}
