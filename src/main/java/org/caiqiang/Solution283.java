package org.caiqiang;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int[] nums2 = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            nums2[index] = num;
            index++;
        }
        System.arraycopy(nums2, 0, nums, 0, nums2.length);
    }
}
