package com.legerito.practice.misc;

import java.util.Arrays;

//Did not do on my own
public class SumClosest {

    public static void main(String[] args) {
        int[] arr = {10, 22, 28, 29, 30, 40};
        System.out.println(Arrays.toString(sumClosest(arr, 54)));
    }

    static int[] sumClosest(int[] arr, int k) {
        int[] result = new int[2];

        int res_l=0, res_r=0;  // To store indexes of result pair

        // Initialize left and right indexes and difference between
        // pair sum and x
        int l = 0, r = arr.length - 1, diff = Integer.MAX_VALUE;

        // While there are elements between l and r
        while (r > l)
        {
            // Check if this pair is closer than the closest pair so far
            if (Math.abs(arr[l] + arr[r] - k) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(arr[l] + arr[r] - k);
            }

            // If this pair has more sum, move to smaller values.
            if (arr[l] + arr[r] > k)
                r--;
            else // Move to larger values
                l++;
        }
        result[0] = arr[res_l];
        result[1] = arr[res_r];

        return result;
    }
}
