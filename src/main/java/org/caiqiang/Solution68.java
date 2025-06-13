package org.caiqiang;


import java.util.ArrayList;
import java.util.List;

public class Solution68 {
    public static void main(String[] args) {
        Solution68 solution68 = new Solution68();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        while (true) {
            String word = words[index];
            if (temp.length() != 0) {
                temp.append(" ");
            }
            if (temp.length() + word.length() <= maxWidth) {
                temp.append(word);
                index++;
            } else {
                // 平均拆分
                if (index >= words.length){
                    //
                    break;
                }else {
                    //
                    temp = new StringBuilder();
                }

            }
        }
        return result;
    }

    // a ab abc   10
    // |a| | |ab| | |abc| | | |
    private String testSplit(String temp, int maxLength,boolean flag) {

        String[] s = temp.split(" ");
        int words = s.length;
        int spans = spanNums(s, maxLength);
        if (!flag){
            // 不是最后一行

        }


        return String.join("", s);
    }

    private int spanNums(String[] s, int maxLength) {
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            count = count + s[i].length();
        }
        return maxLength - count;
    }
}
