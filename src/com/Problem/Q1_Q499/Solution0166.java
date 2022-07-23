package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long frontpart = 0;
        long numeratorlong = (long) numerator;
        long denominatorlong = (long) denominator;
        if (numeratorlong % denominatorlong == 0) {
            return "" + numeratorlong / denominatorlong;
        }
        StringBuffer buffer = new StringBuffer();
        if (numeratorlong < 0 ^ denominator < 0) {
            buffer.append("-");
        }
        long a = Math.abs(numeratorlong);
        long b = Math.abs(denominatorlong);
        if (a > b) {
            frontpart = a / b;
        }
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        buffer.append(frontpart);
        buffer.append(".");
        long backpart = a % b;
        int size = buffer.length();
        int cnt = 0;
        while (backpart != 0 && !map.containsKey(backpart)) {
            map.put(backpart, cnt);
            backpart *= 10;
            buffer.append(backpart / b);
            backpart %= b;
            cnt++;
        }
        if (backpart != 0) {
            int index = map.get(backpart);
            buffer.insert(size + index, '(');
            buffer.append(')');
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Solution0166 s = new Solution0166();
        String a = s.fractionToDecimal(22, 7);
        System.out.println(a);
    }
}
