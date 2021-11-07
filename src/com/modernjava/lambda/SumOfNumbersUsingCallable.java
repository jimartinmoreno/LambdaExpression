package com.modernjava.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.lang.System.*;

public class SumOfNumbersUsingCallable {
    public static int[] array = IntStream.rangeClosed(0, 5000).toArray();
    public static int total = IntStream.rangeClosed(0, 5000).sum();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Callable<Integer> callable1 = () -> {
//            return getSum(0, array.length / 2);
//        };

        Callable<Integer> callable1 = () -> getSum(0, array.length / 2);

//        Callable<Integer> callable2 = () -> {
//            return getSum(array.length / 2, array.length);
//        };
        Callable<Integer> callable2 = () -> getSum(array.length / 2, array.length);


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList = Arrays.asList(callable1, callable2);
        List<Future<Integer>> results = executorService.invokeAll(taskList);

        int k = 0;
        int sum = 0;
        for (Future<Integer> result : results) {
            sum = sum + result.get();
            out.println("Sum of " + ++k + " is: " + result.get());
        }
        out.println("Sum from the Callable is: " + sum);
        out.println("Correct sum from InStream is: " + total);
        out.println("Correct sum from array is: " + Arrays.stream(array).sum());

        executorService.shutdown();

    }

    private static Integer getSum(int initNumber, int finalNumber) {
        int sum = 0;
        for (int i = initNumber; i < finalNumber; i++) {
            sum += array[i];
        }
        return sum;
    }
}
