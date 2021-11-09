package com.modernjava.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        String s = "Hola Mundo Feliz";

        Optional<String> sOpt = Optional.ofNullable(s);

        // Valida la cadena de texto con filtros y evita NPE
        boolean result = sOpt
                .filter(cadena -> !cadena.contains("Bye"))
                .map(String::length)
                .filter(longitud -> longitud > 10 && longitud < 100)
                .isPresent();

        System.out.println("result = " + result);

        //List<String> companyNames = null;
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.ofNullable(companyNames);

        // devuelve el tamaño de la lista y evita NPE
        int size = listOptional.map(List::size).orElse(0);
        System.out.println("size = " + size);

        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        String name = personOptional
                .flatMap(Person::getName)
                .orElse("");

        System.out.println("name = " + name);

    }

}


class Person {
    private String name;
    private int age;
    private String password;

   public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

    // normal constructors and setters
}