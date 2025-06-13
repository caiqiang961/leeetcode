package org.caiqiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @program: leetcode
 * @description:给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-04 18:30
 **/
public class Solution17 {
    private String[] strings = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("2354"));
    }

    public List<String> letterCombinations(String digits) {


        if (digits.length() == 0){
            return new ArrayList<>();
        }
        if (digits.length() == 1){
            String string = strings[Integer.parseInt(digits) - 2];
            String[] split = string.split("");
            return Arrays.asList(split);
        }
        return checkLoop(digits);

    }

    private List<String> checkLoop(String digits){
        if (digits.length() > 2){
            List<String> list1 = checkLoop(digits.substring(1));
            String[] split = strings[Integer.parseInt(digits.substring(0, 1)) - 2].split("");
            StringBuilder sb ;
            List<String> result = new ArrayList<>();
            for (String s : split) {
                for (String value : list1) {
                    sb = new StringBuilder(s);
                    sb.append(value);
                    result.add(sb.toString());
                }
            }

            return result;
        }else { // == 2
            String[] split = digits.split("");
            String[] split1 = strings[Integer.parseInt(split[0]) - 2].split("");
            String[] split2 = strings[Integer.parseInt(split[1]) - 2].split("");

            List<String> result = new ArrayList<>();
            StringBuilder sb ;
            for (String value : split1) {
                for (String s : split2) {
                    sb = new StringBuilder(value);
                    sb.append(s);
                    result.add(sb.toString());
                }
            }
            return result;
        }


    }




}
