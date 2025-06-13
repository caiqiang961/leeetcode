package org.caiqiang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//46. 全排列
//中等
//相关标签
//相关企业
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//示例 2：
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//示例 3：
//
//输入：nums = [1]
//输出：[[1]]
//
//提示：
//1 <= nums.length <= 6
//-10 <= nums[i] <= 10
//nums 中的所有整数 互不相同

//0 1 2 6 24

//1234 1243   123 4   4 123
//1324 1342   12 3 4  4 3 12
//1423 1432   1 2 3 4

//2134 2143
//2314 2341
//2413 2431
public class Solution46 {
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        System.out.println(solution46.permute(new int[]{1, 2, 3,4}));
    }

    public List<List<Integer>> permute(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] use = new boolean[nums.length];
        diGui(queue, use, nums, 0);
        return result;
    }


    //1 2 3
    // 1 2 3

    /**
     *深度优先搜索，首先记录层数或者叫深度
     * @param queue
     * @param use
     * @param nums
     * @param depth 深度记录，或者叫层数记录，达到最深层则可以结束当前层的递归从而返回上一层了
     */
    private void diGui(Deque<Integer> queue, boolean[] use, int[] nums, int depth) {
        if (depth >= nums.length) {
            result.add(new ArrayList<>(queue));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (use[i]) {
                continue;
            }
            queue.addLast(nums[i]);
            use[i] = true;

            diGui(queue, use, nums, depth + 1);

            queue.removeLast();
            use[i] = false;

        }
    }

}
