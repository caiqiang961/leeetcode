package org.caiqiang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//78. 子集
//中等
//相关标签
//相关企业
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
//子集
//（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//示例 2：
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//提示：
//
//1 <= nums.length <= 10
//-10 <= nums[i] <= 10
//nums 中的所有元素 互不相同
public class Solution78 {
    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        System.out.println(solution78.subsets(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        start(result, deque, nums, 0);
        return result;
    }

    private void start(List<List<Integer>> result, Deque<Integer> deque, int[] nums, int currentIndex) {
        result.add(new ArrayList<>(deque));

        for (int i = currentIndex; i < nums.length; i++) {
            deque.addLast(nums[i]);
            start(result, deque, nums, i + 1);
            deque.removeLast();
        }

    }
}
