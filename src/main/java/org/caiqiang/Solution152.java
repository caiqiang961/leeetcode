package org.caiqiang;

import java.util.HashMap;
import java.util.Map;

public class Solution152 {
    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct(new int[]{2,-5,-2,-4,3}));
    }

    public int maxProduct(int[] nums) {
        int[] maxNums = new int[nums.length];
        int[] minNums = new int[nums.length];
        maxNums[0] = nums[0];
        minNums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxNums[i] = Math.max(maxNums[i - 1] * nums[i], Math.max(nums[i], nums[i] * minNums[i - 1]));
            minNums[i] = Math.min(minNums[i - 1] * nums[i], Math.min(nums[i], nums[i] * maxNums[i - 1]));
        }
        int result = maxNums[0];
        for (int i = 0; i < maxNums.length; i++) {
            result = Math.max(result,maxNums[i]);
        }
        return result;
    }
}
