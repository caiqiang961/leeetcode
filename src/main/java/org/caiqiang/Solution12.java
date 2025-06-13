package org.caiqiang;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @program: leetcode
 * @description:罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 *
 * 提示：
 *
 * 1 <= num <= 3999
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-02-25 18:49
 **/
public class Solution12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.intToRoman(1994));
    }

    private static Map<Integer,String> map = new HashMap<Integer, String>();
    private int[] temp = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
    static {
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");

    }
    public String intToRoman(final int num) {

        Map<String,Integer> result = new LinkedHashMap<>();

            check(result,num);

        StringBuilder sb = new StringBuilder("");
        result.forEach((k,v) -> {
            for (int i = 1; i <= v; i++) {
                sb.append(k);
            }
        });
        return sb.toString();
    }

    private void check(Map<String,Integer> result,int num){
        if (num == 0){
            return;
        }

        if (num >= temp[temp.length - 1]){
            int tempx = temp[temp.length - 1];
            result.put(map.get(tempx),num / tempx);
            check(result,num % tempx);
            return;
        }

//        if (num >= 900 && num <1000){
//            int tempx = 900;
//            result.put("CM",num / tempx);
//            check(result,num % tempx);
//            return;
//        }else if (num >= 400 && num <500){
//            int tempx = 400;
//            result.put("CD",num / tempx);
//            check(result,num % tempx);
//            return;
//        }else if (num >= 90 && num < 100){
//            int tempx = 90;
//            result.put("XC",num / tempx);
//            check(result,num % tempx);
//            return;
//        }else if (num >= 40 && num < 50){
//            int tempx = 40;
//            result.put("XL",num / tempx);
//            check(result,num % tempx);
//            return;
//        }else if (num == 9){
//            result.put("IX",1);
//            return;
//        }else if (num == 4){
//            result.put("IV",1);
//            return;
//        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > num){
                int tempx = temp[i - 1];
                result.put(map.get(tempx),num / tempx);
                check(result,num % tempx);
                break;
            }
        }
    }

}
