package org.caiqiang;

public class Solution122 {
    //方法一：动态规划
    //考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
    //
    //定义状态 dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
    //
    //考虑 dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即 dp[i−1][1]，这时候我们要将其卖出，并获得 prices[i] 的收益。因此为了收益最大化，我们列出如下的转移方程：
    //dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}

    //再来考虑 dp[i][1]，按照同样的方式考虑转移状态，那么可能的转移状态为前一天已经持有一支股票，即 dp[i−1][1]，或者前一天结束时还没有股票，即 dp[i−1][0]，这时候我们要将其买入，并减少 prices[i] 的收益。可以列出如下的转移方程：
    //dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}

    //对于初始状态，根据状态定义我们可以知道第 0 天交易结束的时候 dp[0][0]=0，dp[0][1]=−prices[0]。
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][1];
    }

    public int maxProfit2(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]){
                result = result + prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
