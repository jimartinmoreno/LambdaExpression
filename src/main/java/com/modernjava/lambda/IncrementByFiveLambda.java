package com.modernjava.lambda;

import static java.lang.System.*;

public class IncrementByFiveLambda {
    public static void main(String[] args) {
        IncrementByFiveInterface incrementByFiveInterface = x -> x + 5;
        out.println(incrementByFiveInterface.incrementByFive(2));
    }
}
