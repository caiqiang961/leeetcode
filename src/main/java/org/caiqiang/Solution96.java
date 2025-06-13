package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution96 {
    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees(19));
    }

    public int numTrees(int n) {
//        List<TreeNode> start = start(1, n);
//        return start.size();
        return start(19);
    }

    // G(n)表示长度为n时的种类有多少
    // F(i,n)表示长度为n且i为根节点的种类有多少
    // 所以 G(n)  =  F(1,n) + F(2,n) + F(3,n)....+ F(n,n)
    // 同时 如果 F(3,7) = 左(1,2) * 右(4,5,6,7) = G(2) * G(4)
    // F(i,n) = G(i - 1) * G(n - i)
    // G(n) = (i=1,n循环) F(i,n)和 = (i=1,n循环)G(i - 1) * G(n - i)和
    private int start(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    //直接获取list的size出现超时，数据可能性太多了
    private List<TreeNode> start(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNode = start(start, i - 1);
            List<TreeNode> rightNode = start(i + 1, end);
            for (TreeNode left : leftNode) {
                for (TreeNode right : rightNode) {
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    root.left = left;
                    result.add(root);
                }
            }

        }
        return result;
    }
}
