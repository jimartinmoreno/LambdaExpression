package com.modernjava.interfacesdefaults;

import static java.lang.System.*;

public class MultipleInheritanceDebuggingExample implements InterfaceA, InterfaceD {

    @Override
    public void sumA(int num1, int num2) {
        out.println("MultipleInheritanceDebuggingExample.sumA" + (num1 + num2));
    }
}
