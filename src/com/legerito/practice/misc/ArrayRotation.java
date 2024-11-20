package com.legerito.practice.misc;

import java.util.Arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 4, 2, 1, 3};
        rotate(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] arr) {
        int size = arr.length - 1;
        int a = arr[size];

        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = a;
    }
}
