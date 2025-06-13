package org.caiqiang;

public class Solution121 {

    // 暴力遍历，超时
    public int maxProfit(int[] prices) {
        int result = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i; j < prices.length; j++) {
                result = Math.max(prices[j] - prices[i], result);
            }
        }
        return Math.max(result, 0);
    }
    //一次遍历
    public int maxProfit2(int[] prices) {
        int result = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length ; i++) {
            if (prices[i] < min){
                min = prices[i];
            }else if (prices[i] - min > result){
                result = prices[i] - min;
            }
        }
        return result;
    }
}
