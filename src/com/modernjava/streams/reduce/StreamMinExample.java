package com.modernjava.streams.reduce;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamMinExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        //Stream min function
        Optional result = numbers.stream().min(Integer::compareTo);
        System.out.println(result.get());

        //reduce function
        //(0,1) - 0  //(0,3) - 0
        //(0,2) - 0
        int result1 = numbers.stream().reduce(0, (a, b) -> a < b ? a : b);
        System.out.println(result1);

        // Returns the min
        Optional result2 = numbers.stream().reduce((a, b) -> a < b ? a : b);
        System.out.println(result2.get());

        // Returns the min
        Optional result3 = numbers.stream().reduce(Integer::min);
        System.out.println(result3.get());

        // Returns the min
        Optional result4 = numbers.stream().reduce(Math::min);
        System.out.println(result3.get());

        // Returns the instructor with min experience years
        Optional<Instructor> instructor = Instructors.getAll().stream().min(Comparator.comparingInt(Instructor::getYearsOfExperience));
        /*
         * Can be replaced with single expression in functional style
         *      instructor.ifPresent(System.out::println);
         *
         *      if (instructor.isPresent())
         *          System.out.println(instructor.get());
         */
        if (instructor.isPresent())
            System.out.println(instructor.get());

    }
}
