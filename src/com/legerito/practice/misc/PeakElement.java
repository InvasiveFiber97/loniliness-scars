package com.legerito.practice.misc;

public class PeakElement {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int n = 3;
        int A = peakElement(a, n);
        int f = 0;
        if(A<0 && A>=n)
            System.out.println(0);
        else
        {
            if(n==1 && A==0)
                f=1;
            else if(A==0 && a[0]>=a[1])
                f=1;
            else if(A==n-1 && a[n-1]>=a[n-2])
                f=1;
            else if(A >= 0 && A < n && a[A] >=a[A+1] && a[A]>= a[A-1])
                f=1;
            else
                f=0;
            System.out.println(f);
        }
    }

    public static int peakElement(int[] arr,int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return arr[0] >= arr[1] ? 0 : 1;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[i] >= arr[i + 1]) {
                    return i;
                }
            } else if (i == n - 1) {
                if (arr[i] >= arr[i - 1]) {
                    return i;
                }
            } else if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
