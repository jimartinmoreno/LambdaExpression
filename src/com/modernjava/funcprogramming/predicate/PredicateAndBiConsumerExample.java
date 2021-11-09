package com.modernjava.funcprogramming.predicate;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class PredicateAndBiConsumerExample {

    //all instructor who teaches online
    static Predicate<Instructor> predicate1 = (i) -> i.isOnlineCourses() == true;
    //instructor experience is >10
    static Predicate<Instructor> predicate2 = (i) -> i.getYearsOfExperience() > 10;

    //Biconsumer print name and courses
    static BiConsumer<String, List<String>> biConsumer = (name, courses) ->
            System.out.println("name is: " + name + " courses : " + courses);

    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();


        instructors.forEach(instructor -> {
            if (predicate1.and(predicate2).test(instructor))
                biConsumer.accept(instructor.getName(), instructor.getCourses());
        });

        System.out.println("------------------------");

        instructors.stream()
                .filter(predicate1.and(predicate2))
                .forEach(instructor -> biConsumer.accept(instructor.getName(), instructor.getCourses()));

        System.out.println("------------------------");

        instructors.stream()
                .filter(predicate1)
                .filter(predicate2)
                .forEach(instructor -> biConsumer.accept(instructor.getName(), instructor.getCourses()));
    }
}
