package com.Problem.Q1_Q499;

public class Solution0338_Counting_Bits {
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    public static void main(String[] args) {
        Solution0338_Counting_Bits s = new Solution0338_Counting_Bits();
        System.out.println(s.countOnes(10));
    }

}
