package com.Problem.Q500_Q999;

import java.util.HashMap;
import java.util.Map;

public class Solution0904_Fruit_Into_Baskets {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (l < r && map.size() > 2) {
                if (map.get(fruits[l]) > 0)
                    map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution0904_Fruit_Into_Baskets s = new Solution0904_Fruit_Into_Baskets();
        System.out.println(s.totalFruit(new int[]{0, 1, 2, 2}));
    }

}
