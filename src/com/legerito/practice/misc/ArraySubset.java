package com.legerito.practice.misc;

public class ArraySubset {

    public static void main(String[] args) {
        long[] a1 = {3231, 53858, 19, 5, 59, 498, 520, 7, 9, 10, 11, 12};
        long[] a2 = {520, 7, 498, 59, 10, 6, 12};
        System.out.println(isSubset(a1, a2, a1.length, a2.length));
    }

    public static String isSubset( long a1[], long a2[], long n, long m) {
        boolean isPresent = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a2[i] == a1[j]) {
                    isPresent = true;
                    a1[j] = 0;
                    break;
                }

                if(j == n -1) {
                    isPresent = false;
                    break;
                }
            }
            if(!isPresent) {
                break;
            }
        }
        return isPresent ? "Yes" : "No";
    }
}
