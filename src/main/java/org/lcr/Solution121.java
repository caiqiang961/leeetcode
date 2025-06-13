package org.lcr;

// 8
// [2,3,6, 9],
// [4,5,8, 10],
// [5,9,10,12]

// 1
// 3
// 5
public class Solution121 {
    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        solution121.findTargetIn2DPlants(new int[][]{{1},{3},{5}},3);
    }
    public boolean findTargetIn2DPlants(int[][] plants, int target) {
        int i = plants.length - 1;
        int j = 0;
        while (i >= 0 && j < plants[0].length){
            if (plants[i][j] == target){
                return true;
            }else if (plants[i][j]>target){
                i--;
            }else {
                j++;
            }
        }
        return false;
    }
}
