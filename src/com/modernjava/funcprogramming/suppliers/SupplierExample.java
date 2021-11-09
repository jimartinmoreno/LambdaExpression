package com.modernjava.funcprogramming.suppliers;

import com.modernjava.funcprogramming.Instructor;
import com.modernjava.funcprogramming.methodReference.InstructorFactory;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static java.lang.System.out;

public class SupplierExample {

    public static void main(String[] args) {
        IntSupplier supplier = () -> (int) (Math.random() * 1000);
        out.println(supplier.getAsInt());
        out.println(supplier.getAsInt());


        Supplier<String> strSupplier = () -> String.valueOf(Math.random() * 1000);
        out.println(strSupplier.get());
        out.println(strSupplier.get());

        InstructorFactory instructorFactory = Instructor::new;
        Supplier<Instructor> instructorSupplier = () -> instructorFactory.getInstructor("Mike", 10, "Software Developer"
                , "M", true, Arrays.asList("Java Programming", "C++ Programming", "Python Programming"));
        out.println(instructorSupplier.get());

        Supplier<Instructor> instructorSupplier2 = () -> new Instructor("Mike", 10, "Software Developer"
                , "M", true, Arrays.asList("Java Programming", "C++ Programming", "Python Programming"));
        out.println(instructorSupplier2.get());
    }

}
