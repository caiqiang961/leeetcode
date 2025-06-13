package org.lcr;

import org.caiqiang.Solution134;
import org.caiqiang.pojo.TreeNode;

import java.util.*;

public class Solution124 {
    public static void main(String[] args) {
        Solution124 solution124 = new Solution124();
        System.out.println(solution124.deduceTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
    public TreeNode deduceTree(int[] preorder, int[] inorder) {
        return getSonTree(preorder, inorder);
    }

    // 在前序中获取root，在中序中以root分割
    // 在前序中以中序分割的left和right分别构造前序的left和right
    private TreeNode getSonTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        int indexInorder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                indexInorder = i;
                break;
            }
        }
        int[] leftInorder = new int[indexInorder];
        int[] rightInorder = new int[inorder.length - 1 - indexInorder];
        Set<Integer> leftInorderSet = new HashSet<>();
        Set<Integer> rightInorderSet = new HashSet<>();
        for (int i = 0; i < leftInorder.length; i++) {
            leftInorder[i] = inorder[i];
            leftInorderSet.add(inorder[i]);
        }
        for (int i = 0; i < rightInorder.length; i++) {
            rightInorder[i] = inorder[indexInorder + 1 + i];
            rightInorderSet.add(inorder[indexInorder + 1 + i]);
        }

        int[] leftPreorder = new int[leftInorder.length];
        int[] rightPreorder = new int[rightInorder.length];

        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            if (leftInorderSet.contains(preorder[i])) {
                leftPreorder[leftIndex] = preorder[i];
                leftIndex++;
            }
            if (rightInorderSet.contains(preorder[i])) {
                rightPreorder[rightIndex] = preorder[i];
                rightIndex++;
            }
        }

        treeNode.left = getSonTree(leftPreorder, leftInorder);
        treeNode.right = getSonTree(rightPreorder, rightInorder);

        return treeNode;
    }
}
