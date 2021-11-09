package com.modernjava.funcprogramming.consumer;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import static java.lang.System.*;

public class ConsumerExample3 {
    public static void main(String[] args) {
        IntConsumer intConsumer = a -> out.println(a * 10);
        intConsumer.accept(10);

        LongConsumer longConsumer = a -> out.println(a * 10L);
        longConsumer.accept(10L);

        DoubleConsumer doubleConsumer = a -> out.println(a * 10);
        doubleConsumer.accept(10.50);
    }
}
