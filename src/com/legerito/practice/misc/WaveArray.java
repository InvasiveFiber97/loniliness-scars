package com.legerito.practice.misc;

import java.util.Arrays;

public class WaveArray {

    public static void main(String[] args) {
        int[] arr= {2, 4, 7, 8, 9, 10};
        convertToWave(arr.length, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void convertToWave(int n, int[] arr) {

        for (int i = 0; i < n - 1; i = i + 2) {

            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
