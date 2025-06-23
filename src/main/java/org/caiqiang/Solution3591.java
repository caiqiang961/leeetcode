package org.caiqiang;

import java.util.HashMap;
import java.util.Map;

public class Solution3591 {
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Boolean> mapZhiShu = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, oldValue) -> {
                if (oldValue == null) {
                    return 1;
                } else {
                    return oldValue + 1;
                }
            });
        }
        for (Map.Entry<Integer, Integer> next : map.entrySet()) {
            if (next.getValue() > 1) {
                if (isZHiShu(next.getValue(), mapZhiShu)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isZHiShu(int num, Map<Integer, Boolean> mapZhiShu) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
