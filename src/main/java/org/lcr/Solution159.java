package org.lcr;

import java.util.Arrays;

public class Solution159 {
    public int[] inventoryManagement(int[] stock, int cnt) {
        Arrays.sort(stock);
        int[] result = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            result[i] = stock[i];
        }
        return result;
    }
}
