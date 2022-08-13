package com.Problem.Q1_Q499;

import java.util.*;

public class Solution0220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            if (set.size() > k) {
                set.remove((long) nums[i - k - 1]);
            }
            Long temp = set.ceiling((long) nums[i] - t);
            if (temp != null && temp <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    long size;

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        size = t + 1L;
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long cur = (long) nums[i];
            long id = getid(cur);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && cur - map.get(id - 1) <= t) {
                return true;
            }
            if (map.containsKey(id + 1) && map.get(id + 1) - cur <= t) {
                return true;
            }
            map.put(id, cur);
            if (i >= k) {
                map.remove((long) getid(nums[i - k]));
            }
        }
        return false;
    }

    long getid(long i) {
        return i >= 0 ? i / size : (i + 1) / size - 1;
    }

    public static void main(String[] args) {
        Solution0220 s = new Solution0220();
        boolean t = s.containsNearbyAlmostDuplicate2(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
        System.out.println(t);
    }
}
