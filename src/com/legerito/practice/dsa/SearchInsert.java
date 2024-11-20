package com.legerito.practice.dsa;

import java.util.Arrays;

public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(searchInsertV2(nums, 3) + ", " + Arrays.toString(nums));
    }

    public static int searchInsert(int[] nums, int target) {
        int numslen = nums.length;
        if(nums[0] == target) {
            return 0;
        } else if(nums[numslen-1] == target) {
            return numslen - 1;
        } else if (target > nums[numslen - 1]) {
            return numslen;
        }
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == target) {
                index = i;
                break;
            }
            if(nums[i] < target && nums[i+1] >target) {
                index = i + 1;
                break;
            }
        }
        return index;
    }

    public static int searchInsertV2(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }

        return start;
    }
}
