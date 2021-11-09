package com.modernjava.streams.terminal.reduce;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class ReducerSamples {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));

        /**
         * The first one reduces a stream of elements to exactly one element of the stream.
         * The example function compares both persons ages in order to return the person with the maximum age.
         */

        persons.stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);    // Pamela

        /**
         * The second reduce method accepts both an identity value and a BinaryOperator accumulator.
         * This method can be utilized to construct a new Person with the aggregated names and ages
         * from all other persons in the stream
         */
        Person result =
                persons.stream()
                        .reduce(new Person("", 0)
                                , (p1, p2) -> {
                                    p1.age += p2.age;
                                    p1.name += p2.name;
                                    return p1;
                                });

        out.format("name=%s; age=%s", result.name, result.age);
        // name=MaxPeterPamelaDavid; age=76

        /**
         * Calcula la suma de las edades de todas las personas
         *
         * The third reduce method accepts three parameters: an identity value, a BiFunction accumulator
         * and a combiner function of type BinaryOperator. Since the identity values type is not restricted
         * to the Person type, we can utilize this reduction to determine the sum of ages from all persons
         */
        Integer ageSum = persons.stream()
                //.reduce(0, (sum, p) -> sum += p.age, Integer::sum);
                .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

        System.out.println(ageSum);  //
    }
}
