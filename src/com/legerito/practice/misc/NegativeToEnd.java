package com.legerito.practice.misc;

import java.util.Arrays;

public class NegativeToEnd {

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -7, -5, 11, 6};
        segregateElements(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void segregateElements(int[] arr) {

        int[] bifurcated = new int[arr.length];

        int s = 0;
        int e = arr.length - 1;
        for(int n : arr) {
            if (n < 0) {
                bifurcated[e--] = n;
            } else {
                bifurcated[s++] = n;
            }
        }


        int i = 0;
        while (i < s) {
            arr[i] = bifurcated[i++];
        }

        int j = arr.length - 1;
        while (j > e) {
            arr[i++] = bifurcated[j--];
        }
        System.out.println(Arrays.toString(bifurcated));
    }
}
