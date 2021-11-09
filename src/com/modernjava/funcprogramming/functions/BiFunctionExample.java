package com.modernjava.funcprogramming.functions;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.lang.System.*;

public class BiFunctionExample {

    /**
     * Checks if the instructor is for online courses
     */
    //static Predicate<Instructor> isOnlineCourses = i -> i.isOnlineCourses();
    static Predicate<Instructor> isOnlineCourses = Instructor::isOnlineCourses;

    /**
     * Bifuction 2 inputs List<Instructors> and second is predicate which will filter if instructor has online
     */
    static BiFunction<List<Instructor>, Predicate<Instructor>, Map<String, Integer>> mapBiFunction =
            ((instructors, instructorPredicate) -> {
                Map<String, Integer> map = new HashMap<>();
                instructors.forEach(instructor -> {
                    if (instructorPredicate.test(instructor)) {
                        map.put(instructor.getName(), instructor.getYearsOfExperience());
                    }
                });
                return map;
            });

    public static void main(String[] args) {
        //courses and return a map of <String,Integer> string is name and Integer is the years of experience
        out.println(mapBiFunction.apply(Instructors.getAll(), isOnlineCourses));
    }
}
