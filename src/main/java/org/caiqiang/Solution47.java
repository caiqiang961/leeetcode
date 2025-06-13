package org.caiqiang;

import java.util.*;

//47. 全排列 II
//中等
//相关标签
//相关企业
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
//示例 1：
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//示例 2：
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//提示：
//
//1 <= nums.length <= 8
//-10 <= nums[i] <= 10
public class Solution47 {
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> resultSet = new HashSet<>();

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.permuteUnique(new int[]{1, 2, 3, 1}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] use = new boolean[nums.length];
        diGui(deque,use,nums,0);
        result.addAll(resultSet);
        return result;
    }

    private void diGui(Deque<Integer> deque, boolean[] use, int[] nums, int depth) {
        if (depth >= nums.length) {
            resultSet.add(new ArrayList<>(deque));
        }

        for (int i = 0; i < nums.length; i++) {
            if (use[i]) {
                continue;
            }
            deque.addLast(nums[i]);
            use[i] = true;

            diGui(deque, use, nums, depth + 1);

            deque.removeLast();
            use[i] = false;
        }
    }
}
