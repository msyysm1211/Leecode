package com.Problem.Q1_Q499;

import java.util.HashSet;
import java.util.Set;

public class Solution0202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        while (!set.contains(n)) {
            set.add(n);
            n = getNext(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    int getNext(int num) {
        int res = 0;
        while (num > 0) {
            res += (num % 10) * (num % 10);
            num = num / 10;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
