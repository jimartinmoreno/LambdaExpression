package com.modernjava.funcprogramming.methodReference;

import com.modernjava.funcprogramming.Instructor;

import java.util.List;

/**
 * Interface con abstract method whose return type is the same as the Object you want to create
 * The abstract method must match a constructor of the class you want to create
 */
public interface InstructorFactory {
    Instructor getInstructor(String name, int yearsOfExperience, String title,
                             String gender, boolean onlineCourse, List<String> courses);
}
