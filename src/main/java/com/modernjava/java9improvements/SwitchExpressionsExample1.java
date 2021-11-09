package com.modernjava.java9improvements;

import java.time.LocalDate;

public class SwitchExpressionsExample1 {
    public static void main(String[] args) {
        String month = "JANUARY";
        String quarter = switch (month) {
            case "JANUARY", "FEBURARY", "MARCH" -> {
                var isLeapYear = LocalDate.now().isLeapYear();
                /**
                 * yield: Se usa para devolver un valor en la expresion case
                 */
                yield (isLeapYear ? "FIRST QUARTER - LEAP YEAR" : "FIRST QUARTER");
            }
            case "APRIL", "MAY", "JUNE" -> "SECOND QUARTER";
            case "JULY", "AUGUST", "SEPTEMBER" -> "THIRD QUARTER";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "FOURTH QUARTER";
            default -> "UNKNOWN QUARTER";
        };
        System.out.println("quarter = " + quarter);
    }
}
