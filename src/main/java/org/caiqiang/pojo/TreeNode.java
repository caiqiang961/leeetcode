package org.caiqiang.pojo;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String s = val + "";
        if (left != null) {
            s = s + "," + left.toString();
        }else {
            s = s + "," + "null";
        }
        if (right != null) {
            s = s + "," + right.toString();
        }else {
            s = s + "," + "null";
        }
        return s;
    }
}
