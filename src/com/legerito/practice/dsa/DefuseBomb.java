package com.legerito.practice.dsa;

import java.util.Arrays;

public class DefuseBomb {

    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        String s = "aabaaaacaabc";

        System.out.println(takeChars(s, 2));
    }

    public static int[] decrypt(int[] code, int key) {
        int[] result = new int[code.length];
        int n = code.length;
        int start = 0, end =0;
        if(key == 0) return result;

        if(key>0)
        {
            start = 1;
            end = key;
        }
        else
        {
            start = n-Math.abs(key);
            end = n-1;
        }
        int sum = 0;
        for(int i=start; i<=end; i++)
            sum += code[i];
        int a, b;
        for(int i=0; i<n; i++)
        {
            result[i] = sum ;
            a = (start)%n;
            sum = sum - code[a];
            b = (end+1)%n;
            sum = sum + code[b];
            start++;
            end++;
        }

        return result;
    }

    public static int takeCharacters(String s, int k) {

        if (s.length() < 3 * k) {
            return -1;
        }

        int a = 0, b = 0, c = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') a++;
            if(s.charAt(i) == 'b') b++;
            if(s.charAt(i) == 'c') c++;
        }

        if(a < k || b < k || c < k) {
            return -1;
        }

        int start = 0, end = s.length() - 1, timeTaken = 0;
        a = 0; b = 0; c = 0;
        boolean checkFromEnd = false;
        while (a != k || b != k || c != k) {

            char c1 = s.charAt(checkFromEnd ? end : start);

            if(a < k && c1 == 'a') {
                timeTaken++;
                a++;
            } else if (b < k && c1 == 'b') {
                timeTaken++;
                b++;
            } else if (c < k && c1 == 'c') {
                timeTaken++;
                c++;
            }

            if(checkFromEnd) {
                end--;
            } else {
                start++;
            }
            checkFromEnd = !checkFromEnd;
        }

        return timeTaken;
    }

    public static int takeChars(String s, int k) {
        int[] arr = new int[3];  // Array to store frequency of 'a', 'b', and 'c'
        char[] c = s.toCharArray(); // Convert string to char array for faster access
        int cur, len = c.length;

        // Step 1: Traverse from the start to count and find the minimum prefix
        for(cur = 0; cur < len; cur++) {
            arr[c[cur] - 'a']++; // Increment frequency count
            if(arr[0] >= k && arr[1] >= k && arr[2] >= k) break; // Stop when all have at least k
        }
        if(cur == len) return -1; // If not all characters have at least k occurrences

        // Step 2: Sliding window to find the minimum prefix-suffix combination
        int count = cur + 1; // Initial prefix length
        int min = count; // Initialize minimum length
        int end = len - 1; // Pointer at the end of the string

        while(cur >= 0) {
            // Check if reducing prefix would drop below k for any character
            if(arr[c[cur] - 'a'] == k) {
                // Add characters from the suffix until condition is maintained
                while(c[cur] != c[end]) {
                    arr[c[end] - 'a']++; // Add suffix character back to the count
                    end--;
                    count++; // Increase total length
                }
                end--; // Move end pointer inward
            } else {
                // Safe to reduce prefix
                arr[c[cur] - 'a']--; // Decrease frequency of the current prefix character
                count--; // Decrease total length
                min = Math.min(count, min); // Update minimum length
            }
            cur--; // Move prefix pointer inward
        }
        return min; // Return the minimum length
    }
}
