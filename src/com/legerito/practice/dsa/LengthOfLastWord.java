package com.legerito.practice.dsa;

public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        String b1 = "101", b2 = "111";
        System.out.println(mySqrt(5));
    }

    public static int lengthOfLastWord(String s) {
        String str = s.trim();
        int counter = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if(Character.isSpaceChar(str.charAt(i))) {
                break;
            }
            counter++;
        }
        return counter;
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int total = carry;
            if (i >= 0)
                total += a.charAt(i--) - '0';
            if (j >= 0)
                total += b.charAt(j--) - '0';
            result.append(total % 2);
            carry = total / 2;
        }
        return result.reverse().toString();
    }

    public static int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public int sqrt(int x) {

        if(x < 0) return -1;
        if(x == 0 || x == 1) return x;

        int lowerbound = 1;
        int upperbound = x;
        int root = lowerbound + (upperbound - lowerbound)/2;

        while(root > x/root || root+1 <= x/(root+1)){
            if(root > x/root){
                upperbound = root;
            } else {
                lowerbound = root;
            }
            root = lowerbound + (upperbound - lowerbound)/2;
        }
        return root;
    }

//    public static int climbStairs(int n) {
//        int ways = 1;
//
//    }
}
