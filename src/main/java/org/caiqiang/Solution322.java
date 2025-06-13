package org.caiqiang;

public class Solution322 {
    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
//        System.out.println(solution322.coinChange(new int[]{2}, 4));
        System.out.println(solution322.coinChange(new int[]{186,419,83,408}, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin) {
                    if (dp[i - coin] != -1){
                        result = Math.min(dp[i - coin], result);
                    }

                }
            }
            if (result == Integer.MAX_VALUE || result == -1) {
                dp[i] = -1;
            } else {
                dp[i] = result + 1;
            }

        }
        return dp[amount];
    }
}
