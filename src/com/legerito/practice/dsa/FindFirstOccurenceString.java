package com.legerito.practice.dsa;

import java.util.List;

public class FindFirstOccurenceString {

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";

        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        int mn = m - n;
        for (int i = 0; i <= mn; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
