package org.caiqiang;

public class Solution123 {
    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        System.out.println(solution123.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(solution123.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0; //第一天从不持有
        dp[0][1] = -prices[0]; //第一天持有
        dp[0][2] = 0; //第一天 持有再卖出
        dp[0][3] = -prices[0]; //第一天 持有再卖出，再持有
        dp[0][4] = 0; //第一天 持有再卖出，再持有再卖出

        for (int i = 1; i < prices.length; i++) {
            //0表示从不持有
            //1表示第一次持有
            //2表示第一次卖出
            //3表示第二次持有
            //4表示第二次卖出

            // 第i天从不持有的收益 = 第i-1天从不持有的收益
            dp[i][0] = dp[i - 1][0];
            // 第i天第一次持有的收益 = max(第i-1天从不持有的收益-p[i],第i-1天第一次持有的收益)
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i],dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i],dp[i - 1][2]);
            dp[i][3] = Math.max(Math.max(dp[i - 1][2] - prices[i],dp[i - 1][3]),dp[i - 1][1] + prices[i] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i],dp[i - 1][4]);
        }
        return dp[prices.length - 1][4];
    }
}
