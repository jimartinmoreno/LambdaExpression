package com.modernjava.optional;

import java.util.Optional;

import static java.lang.System.*;

public class OptionalOrElseThrowExample {
    public static void main(String[] args) {
        //orElse
        Integer[] numbers = new Integer[10];
        numbers[0] = 1;
        Optional<Integer> number = Optional.ofNullable(numbers[0]);
        int result = number.orElse(-1);
        out.println("result = " + result);

        //orElseGet you expecify a lambda supplier
        result = number.orElseGet(() -> -1);
        out.println("result - orElseGet = " + result);

        //orElse
        number = Optional.ofNullable(numbers[1]);
        result = number.orElse(-1);
        out.println("result orElse = " + result);


        //or If a value is present, returns an Optional describing the value, otherwise returns an
        // Optional produced by the supplying function
        Optional<Integer> resultOp = number.or(() -> Optional.ofNullable(numbers[0]));
        out.println("result - or = " + resultOp);

        number = Optional.ofNullable(numbers[1]);
        resultOp = number.or(() -> Optional.ofNullable(-1));
        out.println("result - or = " + resultOp);



        //orElseThrow
        try {
            result = number.orElseThrow(Exception::new);
            out.println("result orElseThrow = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
