package org.caiqiang;

import java.util.*;

/**
 * @program: leetcode
 * @description:数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-11 15:35
 **/
public class Solution22 {
    //比如n=1时为“（）”，那么n=2时，“0（1）2”，有0,1,2三个位置可以插入一个完整的“（）”，分别得到“（）（）”，“（（））”，以及“（）（）”，
    //去除重复的就得到了n=2时的结果。

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        if (n == 1){
            return Collections.singletonList("()");
        }
        List<String> list = generateParenthesis(n - 1);
        for (String s : list){
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(s.substring(0,i));
                sb .append("()").append( s.substring(i));
                set.add(sb.toString());
            }
        }
        return new ArrayList<>(set);
    }

    public List<String> generateParenthesis1(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<>();
        if (n == 0)
            return result.get(0);
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }
}
