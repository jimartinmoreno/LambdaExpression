package com.modernjava.streams.factory;

import java.util.Random;
import java.util.stream.Stream;

import static java.lang.System.*;

public class StreamFactoryMethodExample {
    public static void main(String[] args) {
        //of
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        stream.forEach(out::println);

        out.println("-----------");
        //iterate generate a stream of 10 even numbers
        stream = Stream.iterate(0, i -> i + 2).limit(10);
        stream.forEach(out::println);

        out.println("--------------");
        //generate 10 random numbers
        stream = Stream.generate(new Random()::nextInt).limit(10);
        stream.forEach(out::println);
    }
}