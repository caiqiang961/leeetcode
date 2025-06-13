package org.caiqiang;

import java.util.Arrays;

// 轮转数组
public class Solution189 {
    public static void main(String[] args) {
        Solution189 solution189 = new Solution189();
        solution189.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
    public void rotate(int[] nums, int k) {
        if (k == nums.length){
            return;
        }
        if (k > nums.length){
            k = k % nums.length ;
        }
        int[] cpNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cpNums[i]= nums[i];
        }
        // k < nums.length
        for (int i = 0; i < nums.length; i++) {

            int index = i + k;
            if (index >= nums.length){
                index = index - nums.length;
            }
            nums[index] = cpNums[i];
        }
        System.out.println(Arrays.toString(nums));
    }
}
