package com.Problem.Q1_Q499;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0170 {
}

class TwoSum {
    HashMap<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }

    public void add(int number) {
        int cnt = map.getOrDefault(number, 0);
        map.put(number, cnt + 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = value - entry.getKey();
            if (num == entry.getKey()) {
                if (entry.getValue() > 2)
                    return true;
            } else {
                if (map.containsKey(num)) {
                    return true;
                }
            }
        }
        return false;
    }
}