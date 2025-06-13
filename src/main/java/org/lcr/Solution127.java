package org.lcr;

public class Solution127 {
    public static void main(String[] args) {
        Solution127 solution127 = new Solution127();
        System.out.println(solution127.trainWays(5));
    }
    public int trainWays(int num) {
        if (num == 0) return 1;
        if (num == 1) return 1;
        if (num == 2) return 2;
        final int MOD = 1000000007;
        int result = 2;
        int preResult = 1;
        int temp;
        for (int i = 3; i <= num; i++) {
            temp = result;
            result = (preResult + result) % MOD;
            preResult = temp;
        }
        return result;
    }
}
