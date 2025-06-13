package org.lcr;

import java.util.HashMap;
import java.util.Map;

public class Solution158 {
    public int inventoryManagement(int[] stock) {
        int x = stock.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        int resultKey = -1;
        int result = -1;
        for (int j : stock) {
            int count = map.compute(j, (k, ov) -> ov == null ? 1 : ov + 1);
            if (result < count){
                result = count;
                resultKey = j;
            }
        }
        return resultKey;
    }
}
