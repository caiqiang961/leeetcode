package org.caiqiang;

/**
 * @program: leetcode
 * @description:给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 20
 * 1 <= p.length <= 30
 * s 只包含从 a-z 的小写字母。
 * p 只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-02-17 18:34
 **/


//未完成
public class Solution10 {

    public boolean isMatch(String s, String p) {
        int lengthS = s.length();
        int lengthP = p.length();

        boolean[][] result = new boolean[lengthS][lengthP];
        int sIndex = 0;
        int pIndex = 0;
        while (true){
            result[sIndex][sIndex] = compare(s.charAt(sIndex),p,pIndex);
        }

    }

    private boolean compare(char s,String pStr,int pIndex){
        char p = pStr.charAt(pIndex);
        if (p != '*'){
            if (p == '.'){
                return true;
             }else {
                return s == p;
            }
        }else {

        }

        return true;
    }
}
