package org.caiqiang;

/**
 * @program: leetcode
 * @description:给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2021-12-02 19:33
 **/
public class Solution7 {
    public static void main(String[] args) {
        Solution7 s = new Solution7();
       System.out.println(s.reverse1(-1534236469));


    }
    public int reverse(int x) {
        String value = String.valueOf(x);
        if (value.length() == 1){
            return x;
        }
        boolean x1 = value.startsWith("-") || value.startsWith("+");
        if (x1 && value.length() > 11){
            return 0;
        }
        if (!x1 && value.length() > 10){
            return 0;
        }
        String temp = null;
        if (value.startsWith("-") || value.startsWith("+")){
            temp = value.substring(0,1);
            value = value.substring(1);
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = value.length() - 1; i >=  0 ; i--) {
            sb.append(value.charAt(i));
        }

        try {
            if (temp!= null){
               return Integer.parseInt(temp + sb.toString());
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    //答案
    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;//取个位
            x /= 10; //取除最后一位
            rev = rev * 10 + digit;
        }
        return rev;
    }


}
