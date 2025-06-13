package org.caiqiang;

/**
 * @program: leetcode
 * @description:实现 strStr() 函数。 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-21 18:31
 * "mississippi"
 * "issip"
 */
public class Solution28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr("mississippi", "issip"));
    }

    //暴力查找
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        char c1 = needle.charAt(0);
        for (int i = 0; i < haystack.length(); i++) {
            char c = haystack.charAt(i);
            if (c == c1) {
                if (needle.length() == 1) {
                    return i;
                }
                for (int j = 1; j < needle.length(); j++) {
                    if (j >= haystack.length()) {
                        return -1;
                    }
                    if (needle.charAt(j) != haystack.charAt(j + i)) {
                        break;
                    }
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }

            }
        }
        return -1;
    }

    //sunday算法   不会写
    public int strStr2(String ss, String pp) {
        if (pp.isEmpty()) return 0;
        int length = pp.length();
        int index = 0;
        while (index < ss.length()){
            char c = ss.charAt(index);
            if (pp.charAt(index) == c){

            }
        }


        return -1;
    }
    // KMP 算法
    // ss: 原串(string)  pp: 匹配串(pattern)
    public int strStr1(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }

}
