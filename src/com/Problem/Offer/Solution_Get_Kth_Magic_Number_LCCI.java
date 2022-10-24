package com.Problem.Offer;

public class Solution_Get_Kth_Magic_Number_LCCI {
    public int getKthMagicNumber(int k) {
        int a = 3, b = 5, c = 7;
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for (int i = 2; i <= k; i++) {
            int num1 = dp[p3] * 3;
            int num2 = dp[p5] * 5;
            int num3 = dp[p7] * 7;
            dp[i] = Math.min(num1, Math.min(num2, num3));
            if (dp[i] == num1) {
                p3++;
            }
            if (dp[i] == num2) {
                p5++;
            }
            if (dp[i] == num3) {
                p7++;
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        Solution_Get_Kth_Magic_Number_LCCI s = new Solution_Get_Kth_Magic_Number_LCCI();
        System.out.println(s.getKthMagicNumber(5));
    }

}
