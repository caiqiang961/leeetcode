package org.lcr;

import java.util.Arrays;

public class Solution128 {
    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        System.out.println(solution128.inventoryManagement(new int[]{2, 3, 7, 4, 6, 1, 3, 3, 3}));
    }
    public int inventoryManagement(int[] stock) {
        maoPaoPaiXu(stock);
        System.out.println(Arrays.toString(stock));
        return stock[0];
    }

    private void maoPaoPaiXu(int[] stock) {
        for (int i = 0; i < stock.length - 1; i++) {
            for (int j = i + 1; j < stock.length; j++) {
                if (stock[i] > stock[j]) {
                    int temp = stock[i];
                    stock[i] = stock[j];
                    stock[j] = temp;
                }
            }
        }
    }
}
