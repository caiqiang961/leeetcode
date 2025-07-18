package org.caiqiang;

public class Solution198 {
    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob(new int[]{2, 1, 1, 2}));
    }
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0],dp[i - 1][1]);
        }

        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
