package org.lcr;

public class Solution170 {


    public int reversePairs(int[] record) {
        int result = 0;

        return result;
    }


    //暴力\超时了
    public int reversePairs1(int[] record) {
        int result = 0;
        for (int i = 0; i < record.length; i++) {
            int current = record[i];
            for (int j = i + 1; j < record.length; j++) {
                if (current > record[j]){
                    result++;
                }
            }
        }
        return result;
    }
}
