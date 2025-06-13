package org.caiqiang;

import java.util.HashMap;
import java.util.Map;

public class Solution76_2 {
    public static void main(String[] args) {
        Solution76_2 solution76_2 = new Solution76_2();
        System.out.println(solution76_2.minWindow("ADOBECODEBANC", "ABC"));
    }

    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> sMap = new HashMap<>();

    // 滑动窗口,时间复杂度太高，超时的优化写法
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;

        int x = -1;
        int y = -1;
        char c = s.charAt(0);
        sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        while (left < s.length() && right < s.length()) {
            if (check()) {
                if ((x == -1 && y == -1) || (y - x + 1 > right - left + 1)) {
                    x = left;
                    y = right;
                }
                char current = s.charAt(left);
                sMap.put(current, sMap.getOrDefault(current, 1) - 1);
                left++;
            } else {
                right++;
                if (right < s.length()) {
                    char current = s.charAt(right);
                    sMap.put(current, sMap.getOrDefault(current, 0) + 1);
                }
            }
        }
        if (x == -1 && y == -1) {
            return "";
        }
        return s.substring(x, y + 1);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> next : tMap.entrySet()) {
            if (!sMap.containsKey(next.getKey())) {
                return false;
            }
            if (sMap.get(next.getKey()) < next.getValue()) {
                return false;
            }
        }
        return true;
    }
}
