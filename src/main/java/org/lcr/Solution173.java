package org.lcr;

public class Solution173 {
    public static void main(String[] args) {
        Solution173 solution173 = new Solution173();
        System.out.println(solution173.takeAttendance(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49}));
    }
    public int takeAttendance(int[] records) {
        if (records[records.length - 1] == records.length - 1) {
            return records.length;
        }
        return dfs(0, records.length - 1, records);
    }

    private int dfs(int start, int end, int[] records) {
        if (start > end) {
            return -1;
        }
        if (start != records[start]){
            return records[start] - 1;
        }
        if (end == records[end]){
            return records[end]+1;
        }
        if (start == end && records[start] != start) {
            return records[start] - 1;
        }
        int middle = (start + end) / 2;
        if (middle == start || middle == end) {
            if (records[middle] == middle) {
                return records[middle] + 1;
            } else {
                return records[middle] - 1;
            }

        }
        if (middle == records[middle]) {
            return dfs(middle + 1, end, records);
        } else {
            return dfs(start, middle -1, records);
        }
    }
}
