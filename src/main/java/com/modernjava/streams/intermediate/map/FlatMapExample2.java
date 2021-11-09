package com.modernjava.streams.intermediate.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Bar> getBars() {
        return bars;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class FlatMapExample2 {
    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();
        // create foos
        IntStream.range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));
        // create bars
        foos.forEach(f -> IntStream.range(1, 4)
                .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

        // 1)
        foos.stream()
                .flatMap(foo -> foo.bars.stream())
                .forEach(bar -> out.println(bar.name));

        // 2)
        foos.stream()
                .map(Foo::getBars)
                .flatMap(List::stream)
                .forEach(bar -> out.println(bar.name));

        // 3) Todo en un paso, inicializaciones y recorrerlo
        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> out.println(b.name));
    }
}
