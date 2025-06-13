package org.caiqiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @program: leetcode
 * @description:给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-07 18:20
 **/
public class Solution18 {

    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        int[] ints = new int[]{1,0,-1,0,-2,2};
//        int[] ints = new int[]{2,2,2,2,2,2};
        System.out.println(solution18.fourSum(ints, 8));
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> result1;




    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            result.addAll(threeSum(nums,first - target ,i,first));
        }
        return result;
    }


    public List<List<Integer>> threeSum(int[] nums,int target,int k,int first) {
        if (nums.length - k < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = k; i < nums.length; i++) {
            List<Integer> list;
            int start = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            //只会加入重复记录
            if (i > k && start == nums[i - 1]){
                continue;
            }

            while (left < right){
                if (start > target){
                    return lists;
                }
                int current = start + nums[left] + nums[right];

                if (current > target){
                    right -- ;
                }else if (current < target){
                    left ++;
                }else {
                    list = new ArrayList<>();
                    list.add(start);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(first);
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



    //错误的递归
    private void check(int[] nums,int i,int target,int count){

        if (count == 4){
            result1 = new ArrayList<>();
        }
        if (count < 1){
            return;
        }
        if (count == 1){
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    result1.add(nums[j]);
                    result.add(result1);
                    return;
                }
            }
        }else {
            for (int j = i; j < nums.length; j++) {
                if (i!=0 && nums[i] == nums[i-1]){
                    return;
                }
                int start = nums[j];
                result1.add(start);
                check(nums,j + 1,target - start,count - 1);
                if (result1.size() == 4){
                    result1 = new ArrayList<>(result1);
                    for (int k = 0; k < count; k++) {
                        result1.remove(result1.size() - 1);
                    }
                }else {
                    result1.remove(4 - count);
                }
            }
        }

    }

    private int add(int num1,int num2){
        return num1 + num2;
    }
}
