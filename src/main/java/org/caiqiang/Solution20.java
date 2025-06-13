package org.caiqiang;

import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

/**
 * @program: leetcode
 * @description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-10 18:24
 **/
public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("()[]{}"));

        char s = '(';
        char s1 = ')';
        char s2 = '{';
        char s3 = '}';
        char s4 = '[';
        char s5 = ']';
        System.out.println((int) s);
        System.out.println((int) s1);
        System.out.println((int) s2);
        System.out.println((int) s3);
        System.out.println((int) s4);
        System.out.println((int) s5);
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(40, 41);
        map.put(123, 125);
        map.put(91, 93);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c == 40 || c == 123 || c == 91) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    int pop = stack.pop();
                    Integer integer = map.get(pop);
                    if (integer == null || integer != c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }


}
