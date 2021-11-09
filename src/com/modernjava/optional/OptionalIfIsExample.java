package com.modernjava.optional;

import java.util.Optional;

public class OptionalIfIsExample {
    public static void main(String[] args) {
        //isPresent
        //Optional<String> stringOptional = Optional.ofNullable("Hello World");
        Optional<String> stringOptional = Optional.ofNullable(null);

        if (stringOptional.isPresent())
            System.out.println("stringOptional = " + stringOptional);
        else
            System.out.println("Empty - else");

        stringOptional.ifPresent(s -> System.out.println("s = " + s));
        stringOptional.ifPresentOrElse(
                s -> System.out.println("s = " + s),
                () -> System.out.println("Empty")
        );

    }
}
