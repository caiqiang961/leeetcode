package org.lcr;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Solution169 {
    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        System.out.println(solution169.dismantlingAction("abbccdeff"));
    }

    public char dismantlingAction(String arr) {
        AtomicReference<Character> result = new AtomicReference<>(' ');
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length(); i++) {
            char c = arr.charAt(i);
            map.merge(c, 1, (ov, nv) -> {
                ov = ov + 1;
                return ov;
            });
        }
        System.out.println(map);
        boolean b = map.entrySet().stream().anyMatch((entry) -> {
            if (entry.getValue()==1){
                result.set(entry.getKey());
                return true;
            }
            return false;
        });
        return result.get();
    }
}
