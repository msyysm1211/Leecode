package com.Problem.Q1000_Q1499;

public class Solution1109_Corporate_Flight_Bookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bookings.length; j++) {
                if (bookings[j][0] <= i + 1 && bookings[j][1] >= i + 1) {
                    res[i] += bookings[j][2];
                }
            }
        }
        return res;
    }

    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            res[bookings[i][0] - 1] += bookings[i][2];
            if (bookings[i][1] < n) {
                res[bookings[i][1]] -= bookings[i][2];
            }
        }
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1109_Corporate_Flight_Bookings s = new Solution1109_Corporate_Flight_Bookings();
        s.corpFlightBookings2(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    }
}
