package org.caiqiang;

import java.util.Arrays;
import java.util.Stack;

public class Solution66 {
    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        System.out.println(Arrays.toString(solution66.plusOne(new int[]{9})));
    }
    public int[] plusOne(int[] digits) {
        int temp = digits[digits.length - 1] + 1;
        if (temp <= 9) {
            digits[digits.length - 1] = temp;
            return digits;
        }
        Stack<Integer> stack = new Stack<>();
        int first = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + first;
            if (digits[i] > 9) {
                int end = digits[i] % 10;
                first = digits[i] / 10;
                stack.push(end);
                if (i == 0){
                    stack.push(first);
                }
            } else {
                stack.push(digits[i]);
                first = 0;
            }

        }
        int[] arr = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()){
            arr[index] = stack.pop();
            index++;
        }
        return arr;
    }
}
