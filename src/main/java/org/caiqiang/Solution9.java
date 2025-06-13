package org.caiqiang;

/**
 * @program: leetcode
 * @description:给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *  
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-02-16 18:14
 **/
public class Solution9 {

    //字符串判断，浪费空间
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        while (leftIndex < rightIndex){
            char leftChar = s.charAt(leftIndex);
            char rightChar = s.charAt(rightIndex);
            if (leftChar != rightChar){
                return false;
            }
            leftIndex ++;
            rightIndex --;
        }
        return true;
    }


    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int left = x;
        int right = 0;
        while (left > right){
            int a = left % 10;
            right = right * 10 + a;
            left = left / 10;
        }
        if (right == left || right / 10 == left ){
            return true;
        }
        return false;
    }

}
