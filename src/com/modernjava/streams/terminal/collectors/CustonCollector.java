package com.modernjava.streams.terminal.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

public class CustonCollector {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),  // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator BiConsumer<StringJoiner, Person>
                        (j1, j2) -> j1.merge(j2),               // combiner:  BinaryOperator<StringJoiner>
                        StringJoiner::toString);                // finisher: Function <StringJoiner, String>

        String names = persons
                .stream()
                .collect(personNameCollector);

        out.println(names);  // MAX | PETER | PAMELA | DAVID

        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2));

        out.println(map); //{18=Max, 23=Peter;Pamela, 12=David}
    }
}
