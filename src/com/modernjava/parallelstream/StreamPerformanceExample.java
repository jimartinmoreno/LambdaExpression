package com.modernjava.parallelstream;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

public class StreamPerformanceExample {
    public static void main(String[] args) {
        int loop = 20;
        IntSupplier sequentialSupplier = StreamPerformanceExample::sumParallelStream;
        IntSupplier parallelSupplier = () -> StreamPerformanceExample.sumParallelStream();
        long result = measurePerformance(sequentialSupplier, loop);
        out.println("Time Taken to process sum in sequential: " + result + " msecs");
        result = measurePerformance(parallelSupplier, loop);
        out.println("Time Takes to process sum in Parallel: " + result + " msecs");
    }

    public static long measurePerformance(IntSupplier supplier, int numberOfTimes) {
        long startTime = currentTimeMillis();
        for (int i = 0; i < numberOfTimes; i++)
            supplier.getAsInt();
        return currentTimeMillis() - startTime;
    }

    public static int sumSequentialStream() {
        return IntStream.rangeClosed(0, 50000).sum();
    }

    public static int sumParallelStream() {
        return IntStream.rangeClosed(0, 50000).parallel().sum();
    }
}
