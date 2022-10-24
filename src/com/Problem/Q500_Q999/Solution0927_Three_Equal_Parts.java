package com.Problem.Q500_Q999;

public class Solution0927_Three_Equal_Parts {
    public int[] threeEqualParts(int[] arr) {
        int count1 = 0;
        for (int i : arr) {
            if (i == 1) {
                count1++;
            }
        }
        if (count1 % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (count1 == 0) {
            return new int[]{0, arr.length - 1};
        }
        int n = arr.length;
        int count = 0;
        int firststart = 0, secondstart = 0, thirdstart = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
            if (count == 1 && firststart == 0 && arr[0] != 1) {
                firststart = i;
            }
            if (count == count1 / 3 + 1 && secondstart == 0) {
                secondstart = i;
            }
            if (count == (count1 * 2) / 3 + 1 && thirdstart == 0) {
                thirdstart = i;
            }
        }
        int len = n - thirdstart;
        for (int i = 0; i < len; i++) {
            if (arr[firststart + i] == arr[secondstart + i] && arr[secondstart + i] == arr[thirdstart + i])
                continue;
            else {
                return new int[]{-1, -1};
            }
        }
        return new int[]{firststart + len - 1, secondstart + len};
    }

    public static void main(String[] args) {
        Solution0927_Three_Equal_Parts s = new Solution0927_Three_Equal_Parts();
        System.out.println(s.threeEqualParts(new int[]{1, 0, 1, 0, 1})[0]);
        System.out.println(s.threeEqualParts(new int[]{1, 0, 1, 0, 1})[0]);
    }

}
