package org.caiqiang;

import java.util.Arrays;

public class Solution88 {
    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] ints = {1, 2, 3, 0, 0, 0};
        solution88.merge(ints,3,new int[]{2,5,6},3);
        System.out.println(Arrays.toString(ints));
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 && nums2.length == 0) {
            return;
        }
        if (nums2.length == 0) {
            return;
        }
        if (nums1.length == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        }

        int[] result = new int[m + n];
        int num1Index = 0;
        int num2Index = 0;
        int resultIndex = 0;
        while (resultIndex < m + n) {
            if (num1Index >= m){
                result[resultIndex] = nums2[num2Index];
                num2Index++;
                resultIndex++;
            }else if (num2Index >= n){
                result[resultIndex] = nums1[num1Index];
                num1Index++;
                resultIndex++;
            }else {
                if (nums1[num1Index] < nums2[num2Index]) {
                    result[resultIndex] = nums1[num1Index];
                    num1Index++;
                    resultIndex++;
                } else if (nums1[num1Index] > nums2[num2Index]) {
                    result[resultIndex] = nums2[num2Index];
                    num2Index++;
                    resultIndex++;
                } else {
                    result[resultIndex] = nums1[num1Index];
                    resultIndex++;
                    result[resultIndex] = nums2[num2Index];
                    num2Index++;
                    num1Index++;
                    resultIndex++;
                }
            }

        }
        System.arraycopy(result, 0, nums1, 0, m + n);
    }


}
