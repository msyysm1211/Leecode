package com.Problem.Q1000_Q1499;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1475_Final_Prices_With_a_Special_Discount_in_a_Shop {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && prices[i] > deque.peek()) {
                deque.pop();
            }
            res[i] = prices[i] - (deque.isEmpty() ? 0 : deque.peek());
            deque.push(prices[i]);
        }
        return res;
    }
}
