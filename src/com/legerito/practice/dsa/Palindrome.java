package com.legerito.practice.dsa;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println("Is palindrome number ? " + isPalindrome(-131));
    }

    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        StringBuilder reversedNumber = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            reversedNumber.append(number.charAt(i));
        }
        return reversedNumber.toString().equals(number);
    }

    /**
     * Optimal Solution
     * @param x
     * @return
     */
    public static boolean isPalindromeV2(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false;

        int reserved = getReserved(x);
        return reserved == x;
    }

    private static int getReserved(int x) {
        int digit = 0;
        while (x > 0) {
            digit = x % 10 + digit * 10;
            x = x / 10;
        }
        return digit;
    }
}
