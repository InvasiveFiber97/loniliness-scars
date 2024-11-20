package com.legerito.practice.misc;

public class MinMaxInArrary {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 56, 10000, 167};
        System.out.println(getMinMax(arr));
    }

    private static Pair<Long, Long> getMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int e : arr) {
            if (e < min) {
                min = e;
            }

            if(e > max) {
                max = e;
            }
        }

        return new Pair<>((long) min, (long) max);
    }

    record Pair<K, V>(K key, V value) {
    }
}
