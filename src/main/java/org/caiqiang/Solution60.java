package org.caiqiang;

import java.util.*;

//60. 排列序列
//困难
//相关标签
//相关企业
//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
//按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//给定 n 和 k，返回第 k 个排列。
//
//
//
//示例 1：
//
//输入：n = 3, k = 3
//输出："213"
//示例 2：
//
//输入：n = 4, k = 9
//输出："2314"
//示例 3：
//
//输入：n = 3, k = 1
//输出："123"
//
//
//提示：
//
//1 <= n <= 9
//1 <= k <= n!
public class Solution60 {
    public static void main(String[] args) {
        Solution60 solution60 = new Solution60();
        System.out.println(solution60.getPermutation(4, 9));
    }
    int count = 0;
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        List<List<Integer>> result = new ArrayList<>();
        return start(arr, k, result, new ArrayDeque<>(), new boolean[n]);
    }

    private String start(int[] arr, int k,  List<List<Integer>> result, Deque<Integer> deque, boolean[] flag) {
        if (deque.size() == arr.length) {
            count++;
            if (k == count) {
                StringJoiner stringJoiner = new StringJoiner("");
                deque.forEach((s) -> {
                    stringJoiner.add(s + "");
                });
                return stringJoiner.toString();
            }
            return null;
        }

        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                continue;
            }
            deque.addLast(arr[i]);
            flag[i] = true;
            String re = start(arr, k, result, deque, flag);
            if (re != null){
                return re;
            }
            deque.removeLast();
            flag[i] = false;
        }
        return null;
    }


}
