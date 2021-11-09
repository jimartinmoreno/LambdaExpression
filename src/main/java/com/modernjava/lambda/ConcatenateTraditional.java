package com.modernjava.lambda;

import static java.lang.System.*;

public class ConcatenateTraditional implements ConcatenateInterface {

    public static void main(String[] args) {
        ConcatenateTraditional concetanateTraditional = new ConcatenateTraditional();
        out.println(concetanateTraditional.sconcat("Hello", "World"));

    }

    @Override
    public String sconcat(String a, String b) {
        return a + " " + b;
    }
}
