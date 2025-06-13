package org.lcr;

public class Solution172 {
    public static void main(String[] args) {
        Solution172 solution172 = new Solution172();
        System.out.println(solution172.countTarget(new int[]{1, 4}, 4));
    }

    // 2分法
    public int countTarget(int[] scores, int target) {
        return dfs(0, scores.length - 1, scores, target);
    }

    private int dfs(int start, int end, int[] scores, int target) {
        if (start > end) {
            return 0;
        }
        int middle = (end + start) / 2;
        if (scores[middle] == target) {
            int left = middle - 1;
            boolean leftFlag = true;
            int right = middle + 1;
            boolean rightFlag = true;
            int result = 1;
            while (left >= start || right <= end) {
                if (left >= start && scores[left] == target) {
                    result++;
                    left--;
                } else {
                    leftFlag = false;
                }
                if (right <= end && scores[right] == target) {
                    result++;
                    right++;
                } else {
                    rightFlag = false;
                }
                if (!leftFlag && !rightFlag) {
                    return result;
                }
            }
            return result;
        }
        if (scores[middle] < target) {
            return dfs(middle + 1, end, scores, target);
        } else {
            return dfs(start, middle - 1, scores, target);
        }
    }

    // 利用升序直接遍历
    public int countTarget1(int[] scores, int target) {
        int result = 0;
        for (int i = 0; i < scores.length; i++) {
            if (target > scores[i]) {
                continue;
            }
            if (target < scores[i]) {
                return result;
            }
            result++;
        }
        return result;
    }
}
