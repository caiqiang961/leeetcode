package org.caiqiang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution128 {
    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        System.out.println(solution128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        AtomicInteger result = new AtomicInteger(1);
        Set<Integer> set = new HashSet<>();
        Set<Integer> setFlag = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        set.forEach(k -> {
            if (setFlag.contains(k)) {
                return;
            }
            int index = 1;
            int currentResult = 1;
            while (true) {
                if (set.contains(k + index)) {
                    setFlag.add(k + index);
                    index++;
                    currentResult ++;
                } else {
                    break;
                }
            }
            result.set(Math.max(result.get(),currentResult));
        });
        return result.get();
    }
}
