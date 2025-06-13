package org.caiqiang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//77. 组合
//中等
//相关标签
//相关企业
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
//你可以按 任何顺序 返回答案。
//
//
//
//示例 1：
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//示例 2：
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//提示：
//
//1 <= n <= 20
//1 <= k <= n
public class Solution77 {
    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        System.out.println(solution77.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        start(result, deque, n, k, 1);
        return result;
    }

    private void start(List<List<Integer>> result, Deque<Integer> deque, int n, int k, int current) {
        if (deque.size() == k) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = current; i <= n; i++) {
            deque.addLast(i);
            start(result, deque, n, k, i + 1);
            deque.removeLast();
        }
    }
}
