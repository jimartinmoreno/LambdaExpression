package com.modernjava.interfacesdefaults;

public interface InterfaceC {
    default void sumC(int num1, int num2) {
        System.out.println("InterfaceC.sumC " + (num1 + num2));
    }

}
