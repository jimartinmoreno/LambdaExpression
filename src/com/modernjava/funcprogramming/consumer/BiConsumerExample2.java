package com.modernjava.funcprogramming.consumer;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.function.BiConsumer;

import static java.lang.System.*;

public class BiConsumerExample2 {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();
        //print out name and gender of instructors
        BiConsumer<String, String> biConsumer = (name, gender) -> out.println("name is :"
                + name + " and gender is: " + gender);
        instructors.forEach(instructor -> biConsumer.accept(instructor.getName(), instructor.getGender()));

        //print out name and Title
        out.println("--------------------");
        BiConsumer<String, String> biConsumer1 = (name, title) -> out.println(
                "name is " + name + " title: " + title);
        instructors.forEach(instructor -> biConsumer1.accept(instructor.getName(), instructor.getTitle()));

        //print out name and list of courses
        out.println("--------------------");
        BiConsumer<String, List<String>> biConsumer2 = (name, courses) -> out.println(
                "name is " + name + " courses: " + courses);
        instructors.forEach(instructor -> biConsumer2.accept(instructor.getName(), instructor.getCourses()));


        //print out name and gender of all instructors who teaches online
        out.println("----------------------");
        instructors.forEach(instructor -> {
            if (instructor.isOnlineCourses())
                biConsumer.andThen(biConsumer1).accept(instructor.getName(), instructor.getGender());
        });

        out.println("----------------------");
        instructors.stream()
                .filter(Instructor::isOnlineCourses)
                .forEach(instructor -> biConsumer.andThen(biConsumer1).accept(instructor.getName(), instructor.getGender()));

    }
}
