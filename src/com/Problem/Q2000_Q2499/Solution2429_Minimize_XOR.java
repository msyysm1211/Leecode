package com.Problem.Q2000_Q2499;

public class Solution2429_Minimize_XOR {
    public int minimizeXor(int num1, int num2) {
        int count2 = Integer.bitCount(num2);
        int count1 = Integer.bitCount(num1);
        if (count1 == count2) {
            return num1;
        }
        int num = 0;
        if (count2 < count1) {
            for (int i = 31; i >= 0; i--) {
                int high = (num1 >> i) & 1;
                if (high == 1) {
                    count2--;
                    num += 1 << i;
                    if (count2 == 0) {
                        break;
                    }
                }
            }
        }
        if (count2 > count1) {
            count2 = count2 - count1;
            for (int i = 0; i < 32; i++) {
                int low = (1 << i) & num1;
                if (low == 0) {
                    count2--;
                    num += 1 << i;
                    if (count2 == 0) {
                        break;
                    }
                }
            }
            num += num1;
        }
        return num;
    }
}
