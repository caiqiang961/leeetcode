package org.caiqiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description:给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-03 17:52
 **/
public class Solution16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] nums = new int[]{-100,-98,-2,-1};
        System.out.println(solution16.threeSumClosest(nums, -101));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);

        int realResult = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 1 && nums[i] == nums[i - 1]){
                continue;
            }

            while (left < right) {
                int result = start + nums[left] + nums[right];
                realResult = check(target, result, realResult);
                if (result > target) {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (result < target) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    return result;
                }


            }
        }

        return realResult;
    }

    private int check(int target, int oldNum,  int realResult) {
        int abs = Math.abs(target - oldNum);
        int abs3 = Math.abs(target - realResult);
        int min = Math.min(abs3, abs);

        if (min == abs)  return oldNum;
        return realResult;

    }
}
