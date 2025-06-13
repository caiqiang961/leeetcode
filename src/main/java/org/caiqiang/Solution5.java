package org.caiqiang;

/**
 * @program: leetcode
 * @description:给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2021-11-26 18:40
 **/
public class Solution5 {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.longestPalindrome("ac"));
    }

    // 暴力   O(n^2) O(n^2)
    public String longestPalindrome(String s) {
       if (s.length()<=1){
           return s;
       }
        int lastIndex;
       String result = "";
        for (int i = 0; i < s.length(); i++) {
            lastIndex = s.length();
            while (lastIndex >= i) {
                String substring = s.substring(i, lastIndex);
                if (substring.length() >= result.length() && huiwen(substring)){
                    result = substring;
                    break;
                }else {
                    lastIndex--;
                }
            }
        }

        return result;
    }
    private boolean huiwen(String substring){
        if (substring.length()<=1){
            return true;
        }
        int left = 0;
        int right = substring.length() - 1;
        while (left <= right){

            char l = substring.charAt(left);
            char r = substring.charAt(right);
            if (r != l){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
   //答案  动态规划   时复O(n^2)   空复O(1)
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
