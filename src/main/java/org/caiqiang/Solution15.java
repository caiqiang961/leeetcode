package org.caiqiang;

import java.util.*;

/**
 * @program: leetcode
 * @description:给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-02 18:46
 **/
public class Solution15 {

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(solution15.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list;
            int start = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            //只会加入重复记录
            if (i > 0 && start == nums[i - 1]){
                continue;
            }

            while (left < right){
                if (start > 0){
                    return lists;
                }
                int current = start + nums[left] + nums[right];

                if (current > 0){
                    right -- ;
                }else if (current < 0){
                    left ++;
                }else {
                    list = new ArrayList<>();
                    list.add(start);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    while (left < right && nums[left]==nums[left+1])  left++;
                    while (left < right && nums[right]==nums[right-1])  right--;
                    right -- ;
                    left ++;
                }

            }

        }
      return lists;
    }

}
