package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

//95. 不同的二叉搜索树 II
//中等
//相关标签
//相关企业
//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
//
//示例 1：
//
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
//示例 2：
//
//输入：n = 1
//输出：[[1]]
public class Solution95 {
    public static void main(String[] args) {
        Solution95 solution95 = new Solution95();
        System.out.println(solution95.generateTrees(3));
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        return start(1, n);
    }

    //左子树为1到(index-1) 右子树为(index + 1)到n
    private List<TreeNode> start(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = start(start, i - 1);
            List<TreeNode> rightNodes = start(i + 1, end);

            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.right = rightNode;
                    root.left = leftNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
