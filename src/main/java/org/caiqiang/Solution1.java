package org.caiqiang;

import java.util.HashMap;
import java.util.Map;
/**
 * @program: leetcode
 * @description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2021-11-19 19:11
 **/
public class Solution1 {
    public static void main(String[] args) {
        int[] x = new int[]{3,2,4};
        int[] ints = twoSum(x, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    ////时复  O(n^2)  空复O(1)
    public static int[] twoSum(int[] nums, int target) {
        int[] x = new int[2];
        for(int i = 0;i < nums.length;i++){
            int a = target - nums[i];
            x[0] = i;
            for (int j = 0; j < nums.length; j++) {
                if (j==i){
                    continue;
                }
                if (a == nums[j]){
                    x[1] = j;
                    break;
                }
            }
            if (nums[x[0]]+nums[x[1]] == target && x[0]!=x[1]){
                break;
            }
        }
        return x;
    }

  //时复  O(n)  空复O(n)
    public static int[] twoSum2(int[] nums, int target) {
        int[] x = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }

        return x;
    }
}
