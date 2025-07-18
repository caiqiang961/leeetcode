package org.caiqiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * @program: leetcode
 * @description:给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 示例 3：
 *
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] 由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-23 18:23
 **/
public class Solution30 {
    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        String[] words = new String[]{"foo","bar"};
        System.out.println(solution30.findSubstring("barfoothefoobarman", words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() == 0){
            return result;
        }
        int wordLength = words[0].length();
        int allLength = wordLength * words.length;
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }

        for (int i = 0; i < s.length() - allLength + 1; i++) {
            HashMap<String,Integer> map1 = new HashMap<>();
            for (int j = i; j < i + allLength; j = j + wordLength) {
                String substring = s.substring(j, j + wordLength);

                if (map.containsKey(substring)){
                    map1.put(substring,map1.getOrDefault(substring,0) + 1);
                }else {
                    break;
                }
                if (map.equals(map1)){
                    result.add(i);
                    break;
                }
            }
        }
            return result;
    }


}
