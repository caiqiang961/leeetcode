package org.lcr;

//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
public class Solution126 {
    public static void main(String[] args) {
        Solution126 solution126 = new Solution126();
//        System.out.println(solution126.fib(45));
        System.out.println(solution126.fib1(5));
    }
    // 递归
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // 循环
    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        final int MOD = 1000000007;
        int result = 1;
        int preResult = 0;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = result;
            result = (preResult + result) % MOD;
            preResult = temp;
        }
        return result;
    }
}
