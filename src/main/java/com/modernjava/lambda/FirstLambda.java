package com.modernjava.lambda;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class FirstLambda {
    public static void main(String[] args) {
        Function<Integer, Integer> f = (Integer i) -> i + 1;
        f.apply(2);
        f = i -> i + 1;
        f.apply(2);

       IntUnaryOperator f2 = i -> i + 1;
       f2.applyAsInt(2);
    }
}
