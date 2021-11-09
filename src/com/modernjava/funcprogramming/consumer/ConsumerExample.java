package com.modernjava.funcprogramming.consumer;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

import static java.lang.System.*;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> c = x -> out.println(x.length() + " the value of x: " + x);
        c.accept("Up in the air");

        //Consumer with block statement
        Consumer<Integer> d = x -> {
            out.println("x*x = " + x * x);
            out.println("x/x = " + x / x);
        };
        d.accept(10);

        //Consumer with block statement
        IntConsumer iC = (x) -> {
            out.println("x*x = " + x * x);
            out.println("x/x = " + x / x);
        };
        iC.accept(10);

    }
}
