package org.caiqiang;

import java.math.BigDecimal;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * 通过次数554,008提交次数1,351,523
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: caiqiang
 * @create: 2021-11-23 19:16
 **/
public class Solution4 {

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.findMedianSortedArrays2(new int[]{1,3}, new int[]{2}));
        //System.out.println(3 & 2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] k = new int[nums1.length + nums2.length];

        int index1 = 0;
        int index2 = 0;
        int index = 0;
        int n1 = 0;
        int n2 = 0;
        boolean i1;
        boolean i2;
        while (index < k.length) {
            if (index1 < nums1.length) {
                n1 = nums1[index1];
                i1 = true;
            } else {
                i1 = false;
            }
            if (index2 < nums2.length) {
                n2 = nums2[index2];
                i2 = true;
            } else {
                i2 = false;
            }
            if (!i1) {
                k[index] = n2;
                index++;
                index2++;
                continue;
            }
            if (!i2) {
                k[index] = n1;
                index++;
                index1++;
                continue;
            }

            if (n1 > n2) {
                k[index] = n2;
                index++;
                index2++;
                continue;
            }

            if (n1 < n2) {
                k[index] = n1;
                index++;
                index1++;
                continue;
            }
            if (n1 == n2) {
                k[index] = n1;
                index++;
                k[index] = n2;
                index++;
                index1++;
                index2++;
            }
        }

        if (k.length % 2 == 0) {
            int i = k.length / 2;
            int temp = k[i - 1] + k[i];
            return Double.parseDouble(String.valueOf(temp)) / 2.0d;
        } else {
            return k[k.length / 2];
        }

    }


    //1,2    3,4  答案
    public double findMedianSortedArrays1(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;

    }

    //1,2    3,4   我的

    /**
     *    不去新建一个数组
     *    只用下表向后遍历 找到中位数
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int index1 = 0;
        int index2 = 0;


        int left =-1;
        int right = -1;
        for (int i = 0; i < len / 2 + 1; i++) {
            left = right;
            if (m > index1 &&  n> index2) {
                if (A[index1] > B[index2]) {
                    right = B[index2];
                    index2++;
                    continue;
                }
                if (A[index1] < B[index2]) {
                    right = A[index1];
                    index1++;
                    continue;
                }
                if (A[index1] == B[index2]) {
                    right=A[index1];
                    index1++;
                    continue;
                }
            }else if (m <= index1){
                right = B[index2];
                index2++;
            }else if (n <= index2){
                right = A[index1];
                index1++;
            }

        }
        if (len % 2 == 0) {
            return (left + right) / 2.0;
        }else {
            return right;
        }

    }


}
