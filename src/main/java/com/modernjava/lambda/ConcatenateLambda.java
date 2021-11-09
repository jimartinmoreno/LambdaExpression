package com.modernjava.lambda;

import static java.lang.System.*;

public class ConcatenateLambda {

    public static void main(String[] args) {
        ConcatenateInterface concatenateInterface = (a, b) -> a + " " + b;
        out.println(concatenateInterface.sconcat("Hello", "World"));
    }
}
