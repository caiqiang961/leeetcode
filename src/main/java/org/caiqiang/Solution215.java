package org.caiqiang;

import java.util.Arrays;

public class Solution215 {
    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        solution215.findKthLargest(new int[]{1,3,5,2,1,4,9,6,8,45,9},2);
    }
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }
}
