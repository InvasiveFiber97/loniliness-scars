package com.legerito.practice.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 13)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(intMap.containsKey(complement)) {
                return new int[]{intMap.get(complement), i};
            }
            intMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
