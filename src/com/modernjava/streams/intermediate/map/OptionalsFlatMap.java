package com.modernjava.streams.intermediate.map;

import java.util.Optional;

class Outer {
    Nested nested;
}

class Nested {
    Inner inner;
}

class Inner {
    String foo;
}

public class OptionalsFlatMap {
    public static void main(String[] args) {
        // In order to resolve the inner string foo of an outer instance you have to add multiple null checks
        // to prevent possible NullPointerExceptions:
        Outer outer = new Outer();
        if (outer != null && outer.nested != null && outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        }

        //The same behavior can be obtained by utilizing optionals flatMap operation:

        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);

    }
}
