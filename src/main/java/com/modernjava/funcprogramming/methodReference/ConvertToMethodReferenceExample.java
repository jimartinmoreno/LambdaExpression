package com.modernjava.funcprogramming.methodReference;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.function.Predicate;

public class ConvertToMethodReferenceExample {
    public static void main(String[] args) {
        Predicate<Instructor> greaterThanTenYearsOfExperiencePredicate = ConvertToMethodReferenceExample::greaterThanTenYearsOfExperience;
        Instructors.getAll().forEach(instructor -> {
            if (greaterThanTenYearsOfExperiencePredicate.test(instructor)) {
                System.out.println(instructor);
            }
        });
    }

    public static boolean greaterThanTenYearsOfExperience(Instructor instructor) {
        return instructor.getYearsOfExperience() > 10;
    }
}
