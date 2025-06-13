package org.caiqiang;

public class Solution134 {
    public static void main(String[] args) {
        Solution134 solution134 = new Solution134();
        System.out.println(solution134.canCompleteCircuit(new int[]{0, 0, 0, 0, 0,2}, new int[]{0, 0, 0, 0, 1, 0}));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]){
                continue;
            }
            int startIndex = i;
            int total = 0;
            while (true) {
                // 假设从第i站开始出发
                total = total + gas[startIndex];
                total = total - cost[startIndex];
                if (total < 0) {
                    break;
                }
                startIndex++;
                if (startIndex >= gas.length){
                    startIndex = startIndex - gas.length;
                }
                if (startIndex == i){
                    return startIndex;
                }
            }
        }
        return -1;
    }
}
