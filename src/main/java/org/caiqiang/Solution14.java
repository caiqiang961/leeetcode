package org.caiqiang;

/**
 * @program: leetcode
 * @description:编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-03-01 18:15
 **/
public class Solution14 {
    public static void main(String[] args) {
        String[] str = new String[]{ "flower","flow","flight"};
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1){
            return "";
        }
        StringBuilder result = new StringBuilder("");
        int arrLeftIndex = 0;
        int arrRightIndex = strs.length - 1 ;
        int chartAtIndex = 0;


        while (true) {
            while (arrLeftIndex <= arrRightIndex) {
                if (chartAtIndex >= strs[0].length()){
                    return result.toString();
                }
                char s = strs[0].charAt(chartAtIndex);

                String strLeft = strs[arrLeftIndex];
                String strRight = strs[arrRightIndex];

                if (chartAtIndex >= strLeft.length() || chartAtIndex >= strRight.length()){
                    return result.toString();
                }
                if (strLeft.charAt(chartAtIndex) != s ||  strRight.charAt(chartAtIndex) != s) {
                  return result.toString();
                }
                arrLeftIndex++;
                arrRightIndex--;
            }
            arrLeftIndex = 0;
            arrRightIndex = strs.length - 1;
            result.append(strs[0].charAt(chartAtIndex));
            chartAtIndex ++;
        }

    }
}
