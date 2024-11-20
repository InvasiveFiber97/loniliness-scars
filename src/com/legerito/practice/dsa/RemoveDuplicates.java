package com.legerito.practice.dsa;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1,1,2,4,4,4,5,6};
        System.out.println(removeDuplicatesV2(nums) + ", " + Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static int removeDuplicatesV2(int[] nums)
    {
        int rd=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[rd]!=nums[i])
            {
                rd++;
                nums[rd]=nums[i];
            }
        }
        rd++;
        return rd;
    }
}
