package com.legerito.practice.dsa;

import java.util.*;

public class ClimbStairs {

    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        System.out.println(maxSubarrSum(nums, 3));
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }

    // Gives out of memory error
    public static long maximumSubarraySum(int[] nums, int k) {
        long result = 0;
        int[] intArray = new int[nums.length];
        int[][] subarrays = new int[nums.length][k];

        for (int i = 0; i < subarrays.length; i++) {
            int temp = i;
            if(temp + k > nums.length) {
                break;
            }
            Set<Integer> integerSet = new HashSet<>();
            for (int j = 0; j < k; j++) {
                if(integerSet.add(nums[temp])) {
                    subarrays[i][j] = nums[temp++];
                }
            }
            intArray[i] = integerSet.size() == k ? integerSet.stream().mapToInt(Integer::intValue).sum() : 0;
        }

        for (int num : intArray) {
            if(result < num) result = num;
        }
        return result;
    }

    // Copied soln
    public static long maxSubarrSum(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> prevIdx = new HashMap<>();
        long curSum = 0;

        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];

            int i = prevIdx.getOrDefault(nums[r], -1);

            while (l <= i || r - l + 1 > k) {
                curSum -= nums[l];
                l++;
            }

            if (r - l + 1 == k) {
                res = Math.max(res, curSum);
            }

            prevIdx.put(nums[r], r);
        }

        return res;
    }
}
