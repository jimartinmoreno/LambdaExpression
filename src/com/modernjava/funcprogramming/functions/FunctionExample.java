package com.modernjava.funcprogramming.functions;

import java.util.function.Function;

public class FunctionExample {
    /**
     * Type parameters:
     * <T> – the type of the input to the function
     * <R> – the type of the result of the function
     */
    static Function<Integer, Double> sqrt = n -> Math.sqrt(n);
    static Function<String, String> lowercaseFunction = s1 -> s1.toLowerCase();
    static Function<String, String> concatFunction = (s) -> s.concat(" In Java");

    public static void main(String[] args) {
        System.out.println("Square root of 64: " + sqrt.apply(64));
        System.out.println("Square root of 81: " + sqrt.apply(81));
        System.out.println(lowercaseFunction.apply("PROGRAMMING"));
        System.out.println(lowercaseFunction.andThen(concatFunction).apply("PROGRAMMING"));
        System.out.println(lowercaseFunction.compose(concatFunction).apply("PROGRAMMING"));
    }
}
