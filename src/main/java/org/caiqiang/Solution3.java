package org.caiqiang;

import java.util.*;

/**
 * @program: leetcode
 * @description:给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2021-11-23 19:16
 **/
public class Solution3 {

    public static void main(String[] args) {
        Solution3 s = new Solution3() ;
        System.out.println(s.lengthOfLongestSubstring("aab"));
    }


    /**
     *   用一个队列   依次放入，遇到重复的弹出第一个，并检查是否还重复，直到不重复，则进行下一个放入  （滑动窗口）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //注意：这里使用hash比使用ArrayList或者LinkList要快很多
       Set<Character> list = new HashSet<Character>();
        int result = -1;int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while(true){
                if (!list.contains(c)){
                    list.add(c);
                    break;
                }else {
                    if (result < list.size()){
                        result = list.size();
                    }
                    list.remove(s.charAt(index));
                    index ++;
                }
            }
        }
        if (result == -1 || result < list.size()){
            result = list.size();
        }
        return result;
    }



}
