package com.modernjava.streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortHashMapByValues {
    public static void main(String[] args) {

        sortingInAscendingOrder();
        sortingInAscendingOrderLongApproach();
    }

    private static void sortingInAscendingOrder() {
        // creating HashMap
        Map<String, Integer> namesAges = new HashMap<>();

        // storing the values
        namesAges.put("Hari", 35);
        namesAges.put("Jhon", 30);
        namesAges.put("Jakey", 50);
        namesAges.put("kane", 45);

        Map<String, Integer> sortByValueMap = namesAges.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                        (entry1, entry2) -> entry2, LinkedHashMap::new));

        System.out.println("HashMap before sorting by value - " + namesAges);
        System.out.println("HashMap after sorting by value - " + sortByValueMap);
    }

    private static void sortingInAscendingOrderLongApproach() {
        // creating HashMap
        Map<String, Integer> namesAges = new HashMap<>();

        // storing the values
        namesAges.put("Hari", 35);
        namesAges.put("Jhon", 30);
        namesAges.put("Jakey", 50);
        namesAges.put("kane", 45);

        // Step 1: Getting the entry set from map
        Set<Map.Entry<String, Integer>> entrySet = namesAges.entrySet();

        // Step 2: converting entry set to stream
        Stream<Map.Entry<String, Integer>> stream = entrySet.stream();

        // Step 3: comparator to sort using values.
        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();

        // Step 4: sorting the stream using comparator created in above step.
        Stream<Map.Entry<String, Integer>> sortedStream = stream.sorted(comparator);

        // Step 5: Getting the each key and value from entry object from above stream.
        // Finally, adding each entry to the LinkedHashMap.
        // LinkedHashMap is used to preserve the insertion order. If you do not collect
        // object into LinkedHashMap then final sorted map looks like same as the
        // original map before sorting.
        Collector<Map.Entry<String, Integer>, ?, Map<String, Integer>> toMap = Collectors.toMap(entry -> entry.getKey(),
                entry -> entry.getValue(), (entry1, entry2) -> entry2, LinkedHashMap::new);

        // Step 6: Collecting the sorted stream into Map.
        Map<String, Integer> finalSortedByValueMap = sortedStream.collect(toMap);

        // printing
        System.out.println("HashMap before sorting by value - " + namesAges);
        System.out.println("HashMap after sorting by value - " + finalSortedByValueMap);
    }

    private static void sortingInDescendingOrder() {
        // creating HashMap
        Map<String, Integer> namesAges = new HashMap<>();

        // storing the values
        namesAges.put("Hari", 35);
        namesAges.put("Jhon", 30);
        namesAges.put("Jakey", 50);
        namesAges.put("kane", 45);

        Map<String, Integer> sortByValueMap = namesAges.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                        (entry1, entry2) -> entry2, LinkedHashMap::new));

        System.out.println("HashMap before sorting by value - " + namesAges);
        System.out.println("HashMap after sorting by value - " + sortByValueMap);
    }

}
