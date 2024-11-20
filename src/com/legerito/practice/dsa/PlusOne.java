package com.legerito.practice.dsa;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] nums = {5,6,2,0,0,4,6,2,4,9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
