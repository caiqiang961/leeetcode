package org.caiqiang;

/**
 * @program: leetcode
 * @description:给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2023-01-31 18:43
 **/
public class Solution34 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 6,6,6,6,7, 7,7, 8, 8, 10,11,11,11,11};
//        int[] nums = new int[]{1};
        Solution34 solution34 = new Solution34();
        int[] ints = solution34.searchRange(nums, 7);
        System.out.println(ints);
    }

    private int[] searchRange(int[] nums, int target) {


        int startIndex = -1;
        int endIndex = -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            if (startIndex == -1 && target == nums[left]) {
                startIndex = left;
            }
            if (startIndex != -1 && target != nums[left]) {
                endIndex = left - 1;
                return new int[]{startIndex, endIndex};
            }
            left++;


            if (endIndex == -1 && target == nums[right]) {
                endIndex = right;
            }
            if (endIndex != -1 && target != nums[right]) {
                startIndex = right + 1;
                return new int[]{startIndex, endIndex};
            }
            right--;
            if (left > right){
                if (startIndex != -1 && endIndex == -1){
                    endIndex = right ;
                }
                if (endIndex != -1 && startIndex == -1){
                    startIndex = left ;
                }
            }
        }
        return new int[]{startIndex, endIndex};
    }
}
