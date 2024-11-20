package com.legerito.practice.misc;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RearrangePositiveNegative {

    public static void main(String[] args) {
        int[] arr = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        rearr(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void rearrange(int[] arr, int n) {
        int positiveSize = 0;
        int negativeSize = 0;

        for (int num : arr) {
            if (num >= 0) {
                positiveSize++;
            } else {
                negativeSize++;
            }
        }

        int[] positiveArray = new int[positiveSize];
        int[] negativeArray = new int[negativeSize];

        int positiveCounter = 0;
        int negativeCounter = 0;
        for (int j : arr) {
            if (j >= 0) {
                positiveArray[positiveCounter] = j;
                positiveCounter++;
            } else {
                negativeArray[negativeCounter] = j;
                negativeCounter++;
            }
        }
        positiveCounter = 0;
        negativeCounter = 0;
        int i = 0;
        while (negativeCounter < negativeArray.length && positiveCounter < positiveArray.length) {
            arr[i++] = positiveArray[positiveCounter++];
            arr[i++] = negativeArray[negativeCounter++];
        }

        while (positiveCounter < positiveArray.length) {
            arr[i++] = positiveArray[positiveCounter++];
        }

        while (negativeCounter < negativeArray.length) {
            arr[i++] = negativeArray[negativeCounter++];
        }
    }

    public static void rearr(int[] arr, int n) {

        int start=0;
        int end=n-1;
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]>=0)nums[start++]=arr[i];
            else nums[end--]=arr[i];
        }
        int st=0;
        int last=n-1;
        for(int i=0;i<n;){
            if(st<start){
                arr[i]=nums[st++];
                i++;
            }
            if(last>end){
                arr[i]=nums[last--];
                i++;
            }
        }
    }
}
