package com.Problem.Q500_Q999;

public class Solution0852 {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1;
        int r = arr.length - 2;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (arr[m] > arr[m + 1] && arr[m] > arr[m - 1]) {
                return m;
            } else if (arr[m] > arr[m + 1] && arr[m] < arr[m - 1]) {
                r = m - 1;
            } else if (arr[m] < arr[m + 1] && arr[m] > arr[m - 1]) {
                l = m + 1;
            }
        }
        return l;
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int l = 1;
        int r = arr.length - 2;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (arr[m] < arr[m - 1]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
