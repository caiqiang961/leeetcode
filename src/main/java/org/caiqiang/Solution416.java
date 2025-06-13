package org.caiqiang;

import java.util.Arrays;

public class Solution416 {
    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        solution416.canPartition(new int[]{1, 5, 11, 5});
    }

    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (target == 0) {
            return true;
        }
        return beiBaoWenTi(target, nums);
    }

    // dp[i][j] = nums[i] > j ? dp[i-1][j] : max(dp[i-1][j],dp[i-1][j-nums[i]])
    private boolean beiBaoWenTi(int target, int[] nums) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0]=true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {

                int index = i - 1;
                if (nums[index] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[index]];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[nums.length][target];
    }
}
