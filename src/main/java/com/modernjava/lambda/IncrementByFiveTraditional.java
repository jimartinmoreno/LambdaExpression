package com.modernjava.lambda;

import static java.lang.System.*;

public class IncrementByFiveTraditional implements IncrementByFiveInterface {
    public static void main(String[] args) {
        IncrementByFiveTraditional incrementByFiveTraditional = new IncrementByFiveTraditional();
        out.println(incrementByFiveTraditional.incrementByFive(2));
    }

    @Override
    public int incrementByFive(int a) {
        return a + 5;
    }
}
