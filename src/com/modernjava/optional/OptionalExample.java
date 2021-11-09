package com.modernjava.optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Integer[] numbers = new Integer[10];
        // int number = numbers[1].intValue();
        // System.out.println("number = " + number);

        /**
         * Optional.of: es obligatorio proporcionar un valor si no genera un nullPointerException
         */
        Optional<String> optionalString = Optional.of("Hello World");
        String s = optionalString.isPresent() ? optionalString.get() : "Empty";
        System.out.println("optionalString = " + s);


        System.out.println("getWords:" + getWords());
        getWords().ifPresent(System.out::println);
    }

    public static Optional<String> getWords() {
        String[] words = new String[10];
        /**
         * Optional.ofNullable: no es obligatorio proporcionar un valor, no genera un nullPointerException
         */
        return Optional.ofNullable(words[1]);
    }
}
