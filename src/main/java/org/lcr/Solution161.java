package org.lcr;

import java.util.Arrays;

public class Solution161 {
    public static void main(String[] args) {
        Solution161 solution161 = new Solution161();
        System.out.println(solution161.maxSales(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    // 动态规划

    public int maxSales(int[] sales) {
        int per = sales[0]; //dp[i - 1]
        int result = sales[0];
        for (int i = 1; i < sales.length; i++) {
            per = Math.max(sales[i], per + sales[i]);
            result = Math.max(result,per);
        }
        return result;
    }
}
