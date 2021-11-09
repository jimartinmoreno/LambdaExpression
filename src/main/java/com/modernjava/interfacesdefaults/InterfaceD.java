package com.modernjava.interfacesdefaults;

public interface InterfaceD {
    default void sumA(int num1, int num2) {
        System.out.println("InterfaceA.sumA " + (num1 + num2));
    }
}
