package org.caiqiang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution46_2_again {

    public static void main(String[] args) {
        Solution46_2_again solution46_2_again = new Solution46_2_again();
        System.out.println(solution46_2_again.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] numFlag = new boolean[nums.length];
        forNums(nums, deque, numFlag, result);
        return result;
    }

    private void forNums(int[] nums, Deque<Integer> deque, boolean[] numFlag, List<List<Integer>> result) {
        if (deque.size() == nums.length) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (numFlag[i]) {
                continue;
            }
            deque.addLast(nums[i]);
            numFlag[i] = true;
            forNums(nums, deque, numFlag, result);
            deque.removeLast();
            numFlag[i] = false;
        }
    }
}
