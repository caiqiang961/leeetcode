package org.lcr;

import java.util.*;
import java.util.stream.Collectors;

public class Solution81 {
    public static void main(String[] args) {
        Solution81 solution81 = new Solution81();
        solution81.combinationSum(new int[]{2,3,6,7},7);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> sets = new HashSet<>();
        if (candidates.length == 0) {
            return null;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(candidates, target, deque, sets);
        return new ArrayList<>(sets);
    }

    private void dfs(int[] candidates, int target, Deque<Integer> deque, Set<List<Integer>> sets) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>(deque);
            Collections.sort(list);
            sets.add(list);
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                deque.addLast(candidates[i]);
                dfs(candidates, target - candidates[i], deque, sets);
                deque.removeLast();
            }
        }
    }
}
