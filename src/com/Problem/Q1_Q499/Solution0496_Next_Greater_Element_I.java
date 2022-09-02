package com.Problem.Q1_Q499;

import com.Problem.Q500_Q999.Solution0547_Number_of_Provinces;

import java.util.*;

public class Solution0496_Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums2[i] >= deque.peek()) {
                deque.pop();
            }
            map.put(nums2[i], deque.isEmpty() ? -1 : deque.peek());
            deque.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution0496_Next_Greater_Element_I s = new Solution0496_Next_Greater_Element_I();
        s.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }
}
