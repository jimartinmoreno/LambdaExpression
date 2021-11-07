package com.modernjava.lambda;

import static java.lang.System.*;

public class HelloWorldLambda {
    public static void main(String[] args) {

        HelloWorldInterface helloWorldInterface2 = () -> {
            return "Hello World Lambda";
        };
        //implementing sayHelloWorld Using Lambda, se puede elminar el return porque esta implicito
        HelloWorldInterface helloWorldInterface = () -> "Hello World Lambda";

        out.println(helloWorldInterface.sayHelloWorld());
        out.println(helloWorldInterface2.sayHelloWorld());
    }
}
