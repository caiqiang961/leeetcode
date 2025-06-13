package org.caiqiang;

/**
 * @program: leetcode
 * @description:将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * <p>
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2021-12-01 19:13
 **/

import java.util.ArrayList;
import java.util.List;

public class Solution6 {

    public String convert(String s, int numRows) {
        int index = 0;
        String convert = convert(s, numRows, index);
        return convert;
    }


    //递归求解   思路：把numRows层变为numRows-1层，同时，除了第0层以外的其他层都需要取0  、temp + numRows + numRows - 2  、 （temp + numRows + numRows - 2+1）多了+1的一个
    public String convert(String s, int numRows, int index) {
        int length = s.length();
        if (length == 1 || length == numRows || numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder("");
        StringBuilder sbTemp = new StringBuilder(s);

        int temp = 0;
        int i = 0;
        while (temp < length) {
            sb.append(s.charAt(temp));
            sbTemp.replace(temp - i, temp + 1 - i, "");
            i++;
            if (index != 0 && temp != 0 && temp < length - 1) {
                temp = temp + 1;
                sb.append(s.charAt(temp));
                sbTemp.replace(temp - i, temp + 1 - i, "");
                i++;
            }
            temp = temp + numRows + numRows - 2;
        }
        sb.append(convert(sbTemp.toString(), numRows - 1, index + 1));
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.convert("PAYPALISHIRING", 4));
    }

    //答案1
    public String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    //答案2
    public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }



}
