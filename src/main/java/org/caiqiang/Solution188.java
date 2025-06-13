package org.caiqiang;

public class Solution188 {
    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        System.out.println(solution188.maxProfit(2, new int[]{2, 4, 1}));
    }

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        for (int i = 0; i <= 2 * k; i++) {
            if (i % 2 == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = -prices[0];
            }
//            System.out.println(dp[0][i]);
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= 2 * k; j++) {

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                if (j % 2 != 0) {
                    //当前值为持有1 3 5 7
                    //max（前一天不持有-今天持有的 ， 前一天持有）
                    dp[i][j] = Math.max(dp[i - 1][j - 1] - prices[i], dp[i - 1][j]);
                } else {
                    //当前值为不持有2 4 6 8
                    //max(前一天持有 + 今天卖出，前一天不持有)
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + prices[i], dp[i - 1][j]);
                }
            }

        }


        return dp[prices.length - 1][2 * k];
    }
}
