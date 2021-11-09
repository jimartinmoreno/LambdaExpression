package com.modernjava.defaults;

import static java.lang.System.*;

public class MathOperationsExample implements Calculator {

    public static void main(String[] args) {
        MathOperationsExample mathOperationsExample = new MathOperationsExample();
        out.println("Sum: " + mathOperationsExample.sum(2, 4));

        //our implementation using lambda expression for sum
        Calculator calculator = (num1, num2) -> num1 % num2;
        out.println("Calculator override using lambda " + calculator.sum(3, 2));

        out.println("Subtract: " + mathOperationsExample.subtract(4, 2));
        out.println("Multiply: " + Calculator.multiply(4, 2));
    }


    @Override
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
}
