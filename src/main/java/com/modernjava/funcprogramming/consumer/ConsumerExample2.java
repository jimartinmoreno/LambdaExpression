package com.modernjava.funcprogramming.consumer;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.*;

public class ConsumerExample2 {
    public static void main(String[] args) {
        List<Instructor> instructors = Instructors.getAll();
        //looping through all the instructor and printing out the values of instructor
        //Consumer<Instructor> c1 = s1 -> System.out.println(s1);
        Consumer<Instructor> c1 = out::println;
        instructors.forEach(c1);
        instructors.forEach(s1 -> out.println(s1));

        //Loop through all the instructor and only print out their name
        out.println("---------------");
        Consumer<Instructor> c2 = s1 -> out.println(s1.getName());
        instructors.forEach(c2);

        //Loop through all the instructors and print out their names and their courses
        out.println("----------------");
        Consumer<Instructor> c3 = s1 -> out.println(s1.getCourses());
        instructors.forEach(c2.andThen(c3));

        //Loop through all the instructors and print out their name if the years of experience is >10
        out.println("----------");
        instructors.forEach(s1 -> {
            if (s1.getYearsOfExperience() > 10) {
                c1.accept(s1);
            }
        });

        //Loop through all the instructors and print out their name and years of experience if years
        //of experience is > 5 and teaches course online
        out.println("--------------");
        instructors.forEach(s1 -> {
            if (s1.getYearsOfExperience() > 5 && !s1.isOnlineCourses()) {
                //c1.andThen(c2).accept(s1);
                c2.andThen(instructor -> out.println(instructor.getYearsOfExperience())).accept(s1);
            }
        });
    }
}
