package org.caiqiang;

// j = 0  k = dp[i - 1][]
// j = 1  k = dp[i-1][j - 1] + dp[i - 1][j]
// j = numRows-1  k=1

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        System.out.println(solution118.generate(5));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int numRow = 1; numRow <= numRows ; numRow++) {
            List<Integer> currentList = new ArrayList<>();
            for (int j = 0; j < numRow; j++) {
                if (j == 0 || j == numRow - 1){
                    currentList.add(1);
                }else {
                    currentList.add(result.get(numRow - 1 - 1).get(j-1) + result.get(numRow - 1 - 1).get(j));
                }
            }
            result.add(currentList);
        }
        return result;
    }
}
