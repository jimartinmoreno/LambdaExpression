package com.modernjava.lambda;

import static java.lang.System.*;

public class RunnableExample {
    public static void main(String[] args) {
        //Runnable Traditional example
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++)
                    sum += i;
                out.println("Traditional: " + sum);
            }
        };
        new Thread(runnable).start();

        //Implement using Lambda
        Runnable runnable1 = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++)
                sum += i;
            out.println("Runnable Lambda: " + sum);
        };

        new Thread(runnable1).start();

        //Implement using Thread with lambda
        new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++)
                sum = sum + i;
            out.println("Thread Lambda: " + sum);

        }).start();
    }
}
