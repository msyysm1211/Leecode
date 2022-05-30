package com.Problem.Q1_Q499;

import java.util.ArrayList;
import java.util.List;

class Solution0229 {
    public List<Integer> majorityElement(int[] nums) {
        int vote1 = 0;
        int vote2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for (int i : nums) {
            if (vote1 > 0 && candidate1 == i) {
                vote1++;
            } else if (vote2 > 0 && candidate2 == i) {
                vote2++;
            } else if (vote1 == 0) {
                candidate1 = i;
                vote1++;
            } else if (vote2 == 0) {
                candidate2 = i;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i : nums) {
            if (vote1 > 0 && candidate1 == i) {
                cnt1++;
            }
            if (vote2 > 0 && candidate2 == i) {
                cnt2++;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(candidate1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(candidate2);
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution0229 s = new Solution0229();
        s.majorityElement(new int[]{2, 3, 2});
    }
}