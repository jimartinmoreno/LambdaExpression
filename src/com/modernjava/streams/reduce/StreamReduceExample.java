package com.modernjava.streams.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //0 +1 = 1        //10+5= 15    //36+9=45
        //1 + 2 = 3        //15+ 6= 21
        //3 + 3 = 6        //21+7 = 28
        //6+ 4 = 10        //28+8 = 36
        int results = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(results);

        results = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(results);

        System.out.println("--------");

        //1 * 1 = 1     //0*1 = 0
        //1 * 2 = 2     //0*2=0
        results = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(results);

        Optional result2 = numbers.stream().reduce((a, b) -> a * b);

        if (result2.isPresent())
            System.out.println(result2.get());

        List<String> strings = Arrays.asList("Hola", "Mundo", "!!!");

        //0 +1 = 1        //10+5= 15    //36+9=45
        //1 + 2 = 3        //15+ 6= 21
        //3 + 3 = 6        //21+7 = 28
        //6+ 4 = 10        //28+8 = 36
        String stringResult = strings.stream().reduce(">", (a, b) -> a.concat(" ").concat(b));
        System.out.println(stringResult);

        Optional stringResultOpt = strings.stream().reduce((a, b) -> a.concat(" ").concat(b));
        if (stringResultOpt.isPresent())
            System.out.println(stringResultOpt.get());
    }
}
