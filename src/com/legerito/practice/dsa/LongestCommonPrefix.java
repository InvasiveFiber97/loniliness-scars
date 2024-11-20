package com.legerito.practice.dsa;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"shambles","shaver","saka"}));
        System.out.println(integerToBinary(1));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        String pref = strs[0];
        for(String s : strs){
            int len = Math.min(s.length(), pref.length());
            for(int i = len; i >= 0;i--){
                if(pref.indexOf(s.substring(0,i)) == 0){
                    pref = s.substring(0,i);
                    break;
                }
            }
        }
        return pref;
    }

    public static String integerToBinary(int number) {
        // Check for special cases
        if (number == 0) {
            return "0";
        }

        // Create a StringBuilder to store the binary representation
        StringBuilder binary = new StringBuilder();

        // Perform the conversion
        while (number > 0) {
            // Append the least significant bit to the binary representation
            binary.insert(0, number & 1);
            // Right shift the number by 1 bit
            number >>= 1;
        }

        // Convert StringBuilder to String and return
        return binary.toString();
    }
}
