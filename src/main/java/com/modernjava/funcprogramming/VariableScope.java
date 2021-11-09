package com.modernjava.funcprogramming;

import java.util.List;
import java.util.function.IntConsumer;

public class VariableScope {
    static int k = 0;

    public static void main(String[] args) {
        /**
         * No se puede modificar ninguna variable local que se use en el
         * contexto de una función lambda
         */
        int b = 10; //local variable

        //IntConsumer intConsumer = (b) -> { //Error Variable 'b' is already defined in the scope
        IntConsumer intConsumer = (a) -> {
            System.out.println(a * b);
            k++;
            System.out.println(k);
            //b++; //Error Variable used in lambda expression should be final or effectively final
        };
        //b++; //Error Variable used in lambda expression should be final or effectively final
        intConsumer.accept(1);

        List<Instructor> instructors = Instructors.getAll();
        instructors.forEach(instructor -> {
            System.out.println(instructor + " " + k);
        });
        k++;
    }
}
