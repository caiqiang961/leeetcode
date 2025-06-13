package org.caiqiang;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution438 {
    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        System.out.println(solution438.findAnagrams("cbaebabacd", "abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.compute(p.charAt(i), (k, ov) -> {
                if (ov == null) {
                    return 1;
                } else {
                    return ov + 1;
                }
            });
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (huaDonChuangKou(i, s, p, map)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean huaDonChuangKou(int startIndex, String s, String p, Map<Character, Integer> map) {
        if (startIndex + p.length() > s.length()) {
            return false;
        }
        String substring = s.substring(startIndex, startIndex + p.length());

        Map<Character, Integer> currMap = new HashMap<>();
        for (int i = 0; i < substring.length(); i++) {
            char curr = substring.charAt(i);
            if (!map.containsKey(curr)) {
                return false;
            }
            currMap.compute(substring.charAt(i), (k, ov) -> {
                if (ov == null) {
                    return 1;
                } else {
                    return ov + 1;
                }
            });
        }
        AtomicBoolean result = new AtomicBoolean(true);

        currMap.forEach((k, v) -> {
            if (!Objects.equals(map.get(k), v)) {
                result.set(false);
            }
        });
        return result.get();
    }


}
