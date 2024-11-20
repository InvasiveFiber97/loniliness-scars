package com.legerito.practice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>(List.of(1,2,3,4,5,6));

        double sum = integers.stream()
                .mapToDouble(value -> (double) value)
                .reduce(0.00, (left, right) -> (left + right)) / integers.size();
//                .average()
//                .orElse(0.0);

        List < Integer > numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14);

        int evenSum = numbers.stream()
                        .filter(integer -> integer % 2 == 0)
                                .mapToInt(value -> value)
                                        .reduce(0, (left, right) -> left + right);
        int sumOfOdds = numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        List < Integer > nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);

        Integer max_val = nums.stream()
                .reduce((o1, o2) -> {
                    if(o1.compareTo(o2) > -1) {
                        return o2;
                    } else {
                        return o1;
                    }
                }).get();

        System.out.println(max_val);
    }
}
