package com.Problem.Q2000_Q2499;

public class Solution2105_Watering_Plants_II {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int l = 0, r = n - 1;
        int acarry = capacityA;
        int bcarry = capacityB;
        int count = 0;
        while (l <= r) {
            if (l == r) {
                int cap = Math.max(acarry, bcarry);
                if (cap < plants[l]) {
                    count++;
                }
            } else {
                if (plants[l] > acarry) {
                    acarry = capacityA;
                    count++;
                }
                acarry -= plants[l];
                if (plants[r] > bcarry) {
                    bcarry = capacityB;
                    count++;
                }
                bcarry -= plants[r];

            }
            l++;
            r--;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2105_Watering_Plants_II s = new Solution2105_Watering_Plants_II();
        System.out.println(s.minimumRefill(new int[]{3, 4, 6, 6, 5}, 7, 6));
    }

}
