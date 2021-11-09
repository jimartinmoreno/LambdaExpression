package com.modernjava.streams.numeric;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxingUnBoxingExample {
    public static void main(String[] args) {
        List<Integer> numbers;

        IntStream numStream = IntStream.rangeClosed(0, 5000); //primitive int stream
        numbers = numStream
                .boxed() // To perform boxing from int to Integer
                .collect(Collectors.toList());
        numbers.forEach(System.out::println);

        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        if (sum.isPresent())
            System.out.println(sum.get());

        int sum1 = numbers.stream()
                .mapToInt(Integer::intValue) // To perform unboxing from Integer to int
                .sum();
        System.out.println(sum1);
    }
}
