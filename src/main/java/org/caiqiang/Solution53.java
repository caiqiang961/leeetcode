package org.caiqiang;

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//子数组
//是数组中的一个连续部分。
//
//
//
//示例 1：
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//示例 2：
//
//输入：nums = [1]
//输出：1
//示例 3：
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//
//提示：
//
//1 <= nums.length <= 105
//-104 <= nums[i] <= 104
//
//
//进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。


public class Solution53 {


    // f(i)代表以下标为i的这个数结尾的最大和 max=nums[i]
    //                                 max=nums[i]+f(i-1)
    // f(0) = nums[0]
    // f(1) = nums[1] || nums[1]+f(0)
    // f(2) = nums[2] || nums[2]+f(1)
    // f(n) = nums[n] || nums[n]+f(n-1)

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxArr = new int[nums.length];
        maxArr[0] = nums[0];
        int max = maxArr[0];

        for (int i = 1; i < nums.length; i++) {
            maxArr[i] = Math.max(nums[i],nums[i]+maxArr[i-1]);
            max = Math.max(max, maxArr[i]);
        }
        return max;
    }
}
