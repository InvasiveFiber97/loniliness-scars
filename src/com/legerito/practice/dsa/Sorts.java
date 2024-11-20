package com.legerito.practice.dsa;

import java.util.Arrays;

public class Sorts {

    public static void main(String[] args) {
        int[] array = {20,35,-15,7,55,1,-22};
        insertionSort(array);
        String adw = "Hiten";
        adw.trim();
    }

    private static void insertionSort(int[] array) {
        int[] sortedArray = array.clone();
        int arrayLength = sortedArray.length;
        int newElement;

        for(int i = 1; i < arrayLength; i++) {
            newElement = sortedArray[i];
            int j;
            for(j = i; j > 0 && sortedArray[j - 1] > newElement; j--) {
                sortedArray[j] = sortedArray[j - 1];
            }

            sortedArray[j] = newElement;
        }

        System.out.println(Arrays.toString(sortedArray));
    }

    private static void selectionSort(int[] array) {
        int[] sortedArray = array.clone();
        int largestElement;
        int unsortedIndex = sortedArray.length;
        for(int i = unsortedIndex - 1; i > 0; i--) {
            largestElement = 0;
            for(int j = 1; j <= i - 1; j++) {
                if(sortedArray[j] > sortedArray[largestElement]) {
                    largestElement = j;
                }
            }
            swap(sortedArray, i, largestElement);
        }
        System.out.println(Arrays.toString(sortedArray));
    }

    private static void bubbleSort(int[] array) {
        int[] sortedArray = array.clone();
        int unsortedPartition = array.length - 1;
        for (int j = unsortedPartition; unsortedPartition > 0; unsortedPartition--) {
            for(int i = 0; i < j; i++) {
                if(sortedArray[i] > sortedArray[i+1]) {
                    swap(sortedArray, i, i+1);
                }
            }
        }
        System.out.println(Arrays.toString(sortedArray));
    }

    private static void swap(int[] array, int index1, int index2) {
        if(array[index1] == array[index2]) {
            return;
        }
        array[index1] = array[index1] + array[index2];
        array[index2] = array[index1] - array[index2];
        array[index1] = array[index1] - array[index2];
    }
}
