package org.caiqiang;

import java.util.HashMap;
import java.util.Map;

//76. 最小覆盖子串
//困难
//相关标签
//相关企业
//提示
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//
//
//注意：
//
//对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//示例 1：
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
//示例 2：
//
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
//示例 3:
//
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。
//
//
//提示：
//
//m == s.length
//n == t.length
//1 <= m, n <= 105
//s 和 t 由英文字母组成
//
//
//进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
public class Solution76 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow("ADOBECODEBANC", "ABC"));
    }

    Map<Character, Boolean> tMap = new HashMap<>();

    // 滑动窗口,时间复杂度太高，超时
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int x = 0;
        int y = 0;
        while (left < s.length() && right < s.length()) {
            if (testStr(s, t, left, right)) {
                if ((x == 0 && y == 0) || (y - x + 1 > right - left + 1)) {
                    x = left;
                    y = right;
                }
                left++;
            } else {
                right++;
            }
        }
        return s.substring(x,y + 1);
    }

    private boolean testStr(String s, String t, int left, int right) {
        if (right - left + 1 < t.length()) {
            return false;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            boolean flagb = false;
            for (int j = left; j <= right; j++) {
                if (s.charAt(j) == t.charAt(i) && !map.getOrDefault(j, false)) {
                    map.put(j, true);
                    flagb = true;
                    break;
                }
            }
            if (!flagb) {
                return false;
            }
        }
        return true;
    }
}
