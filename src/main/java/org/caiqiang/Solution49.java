package org.caiqiang;

import java.util.*;

//49. 字母异位词分组
//中等
//相关标签
//相关企业
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//示例 1:
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//示例 2:
//
//输入: strs = [""]
//输出: [[""]]
//示例 3:
//
//输入: strs = ["a"]
//输出: [["a"]]
//
//
//提示：
//
//1 <= strs.length <= 104
//0 <= strs[i].length <= 100
//strs[i] 仅包含小写字母
public class Solution49 {
    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        System.out.println(solution49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int hashSum = strSum(str);
            List<String> list = map.getOrDefault(hashSum,new ArrayList<>());
            list.add(str);
            map.put(hashSum,list);
        }
        map.forEach((k,v)->{
            result.add(v);
        });
        return result;
    }

    private int strSum(String str){
        String[] split = str.split("");
        Arrays.sort(split);
        StringBuilder temp = new StringBuilder();
        for (String s : split) {
            temp.append(s);
        }
        return temp.toString().hashCode();
    }
}
