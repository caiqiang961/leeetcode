package org.caiqiang;

import java.util.*;

/**
 * @program: leetcode
 * @description:给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。 
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2023-07-17 18:01
 **/
public class Solution40 {

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] arr1 = new int[]{10, 1, 2, 7, 6, 1, 5};
        int[] arr2 = new int[]{2,5,2,1,2};
        int[] arr3 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(solution40.combinationSum2(arr1, 8));
        System.out.println(solution40.combinationSum2(arr2, 5));
        System.out.println(solution40.combinationSum2(arr3, 30));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> set = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        ack(candidates, target, 0, queue, set);

        return new ArrayList<>(set);
    }

    private void ack(int[] candidates, int target, int index, Deque<Integer> queue, Set<List<Integer>> lists) {

        if (target == 0) {
            ArrayList<Integer> integers = new ArrayList<>(queue);
            Collections.sort(integers);
            lists.add(integers);
            return;
        }
        if (target < 0){
            return;
        }


        while (index < candidates.length){
            queue.addLast(candidates[index]);
            ack(candidates, target - candidates[index], index + 1, queue, lists);
            queue.removeLast();
            index ++;
        }

    }

}
