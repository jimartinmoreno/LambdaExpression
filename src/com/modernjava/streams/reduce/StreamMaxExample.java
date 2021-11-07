package com.modernjava.streams.reduce;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.Instructors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamMaxExample {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        //max using stream max function
        Optional<Integer> result = numbers.stream().max(Integer::compareTo);
        System.out.println(result.get());
        //(0,1) - 1   // return 0
        //(1,2) - 2
        //(2,3) - 3

        // Returns the max
        int result2 = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(result2);

        // Returns the max
        Optional<Integer> result3 = numbers.stream().reduce((a, b) -> a > b ? a : b);
        System.out.println(result3.get());

        // Returns the max
        Optional<Integer> result4 = numbers.stream().reduce(Math::max);
        System.out.println(result4.get());

        // Returns the max
        Optional<Integer> result5 = numbers.stream().reduce(Integer::max);
        System.out.println(result5.get());

        // Returns the instructor with max experience years
        Optional<Instructor> instructor = Instructors.getAll().stream().max(Comparator.comparing(Instructor::getYearsOfExperience));
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
