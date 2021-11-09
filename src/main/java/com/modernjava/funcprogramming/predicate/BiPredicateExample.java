package com.modernjava.funcprogramming.predicate;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class BiPredicateExample {

    private static BiPredicate<Boolean, Integer> predicate = (online, experience) -> online == true && experience > 10;
    //Biconsumer print name and courses
    private static BiConsumer<String, List<String>> biConsumer = (name, courses) -> System.out.println("name is: " + name + " courses : " + courses);

    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();
        instructors.forEach(instructor -> {
            if (predicate.test(instructor.isOnlineCourses(), instructor.getYearsOfExperience()))
                biConsumer.accept(instructor.getName(), instructor.getCourses());
        });
    }
}
