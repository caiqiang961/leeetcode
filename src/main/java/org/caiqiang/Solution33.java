package org.caiqiang;

/**
 * @program: leetcode
 * @description:整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang //   4 5 6 7 8 9 1 2
 * @create: 2023-01-30 18:20
 **/
public class Solution33 {

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();

//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        int[] nums = new int[]{30,40,50,60,70,10,20};
        int[] nums = new int[]{10,20,30,40,50,60,70};
        System.out.println(solution33.search(nums, 60));
    }


    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int start = nums[0];
        int end = nums[nums.length - 1];

        if (start > end) {  //旋转了
            if (target < start && target > end){
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {

                if (nums[left] < nums[right]) {//找到一个升序数组  使用二分查找
                    return halfFind(left, right, nums, target);
                }

                if (target > nums[left]) {//向右比较
                    left++;
                } else if (target == nums[left]) {
                    return left;
                }else {
                   if (left - 1 >= 0 && nums[left] > nums[left - 1]){//在升序中俩个数之间不存在 则返回
                       return -1;
                   }
                }

                if (target < nums[right]) {//向左比较
                    right--;
                } else if (target == nums[right]) {
                    return right;
                }else {
                    if (right + 1 <= nums.length - 1 && nums[right] < nums[right + 1]){//在降序中俩个数之间不存在 则返回
                        return -1;
                    }
                }
            }
            return -1;
        } else if (start == end) {
            //只有一个值
            return start == target ? 0 : -1;
        } else {//start < end 没有旋转 二分查找
            return halfFind(0, nums.length - 1, nums, target);
        }
    }





    private int halfFind(int leftIndex, int rightIndex, int[] nums, int target) {

        int left = leftIndex;
        int right = rightIndex;

        while (left <= right) {
            if (target > nums[left]) {
                left++;
            } else if (nums[left] == target) {
                return left;
            } else {
                return -1;
            }
            if (target < nums[right]) {
                right--;
            } else if (nums[right] == target) {
                return right;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
