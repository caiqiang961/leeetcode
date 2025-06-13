package org.caiqiang;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution169 {
    public int majorityElement(int[] nums) {
        int num = nums.length / 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer compute = map.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
            if (compute > num){
                return nums[i];
            }
        }
        AtomicInteger result = new AtomicInteger(-1);
        map.forEach((k,v) ->{
            if (v > num){
                result.set(k);
            }
        });
        return result.get();
    }
}
