package org.caiqiang;

/**
 * @program: leetcode
 * @description:给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2023-02-01 18:25
 **/
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int length = nums.length - 1;

        while (left <= right) {
            if (target > nums[left]) {
                if (left + 1 <= length && target < nums[left + 1]) {
                    return left + 1;
                }
                if (left + 1 > length) {
                    return left + 1;
                }
                left++;
            } else {
                return left;
            }
            if (target < nums[right]) {
                if (right - 1 >= 0 && target > nums[right - 1]){
                    return right;
                }
                right--;
            } else if (nums[right] == target) {
                return right;
            } else {
                return right + 1;
            }
        }
        return -1;
    }


}
