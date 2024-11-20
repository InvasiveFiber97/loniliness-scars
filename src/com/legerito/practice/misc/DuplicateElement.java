package com.legerito.practice.misc;

import java.util.ArrayList;
import java.util.Collections;

public class DuplicateElement {

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,3};
        TwoStacks twoStacks = new TwoStacks();
        twoStacks.push1(1);
        twoStacks.push2(2);
        System.out.print(twoStacks.pop1());
        twoStacks.push1(3);
        System.out.print(twoStacks.pop1());
        System.out.print(twoStacks.pop1());
    }

    public static ArrayList<Integer> duplicates(int[] arr) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> duplicates = new ArrayList<>();

        for (int n : arr) {

            if(integers.contains(n)) {
                if(!duplicates.contains(n)) duplicates.add(n);
            } else {
                integers.add(n);
            }
        }

        if(duplicates.isEmpty()) {
            duplicates.add(-1);
        }

        Collections.sort(duplicates);
        return duplicates;
    }
}
