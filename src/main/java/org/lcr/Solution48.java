package org.lcr;

import org.caiqiang.pojo.TreeNode;

public class Solution48 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        String valueStr = solution48.serialize(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5))));
        TreeNode deserialize = solution48.deserialize(valueStr);
        System.out.println(deserialize);

    }

    // Encodes a tree to a single string.
    // 坑：有可能是正数、负数、多位数
    public String serialize(TreeNode root) {
        if (root == null) {
            return "*";
        }
        String s = "";
        s = s + root.val + ",";
        s = s + serialize(root.left)+ ",";
        s = s + serialize(root.right)+ ",";
        return s.substring(0,s.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        return deserialize(split, 0).value;
    }

    private Temp deserialize(String[] data, int index) {

        if (index >= data.length) {
            return new Temp(null, index + 1);
        }
        String currentValue = data[index];
        if (currentValue.equals("*")) {
            return new Temp(null, index + 1);
        }
        TreeNode treeNode = new TreeNode();
        treeNode.val = Integer.parseInt(currentValue);
        Temp deserialize = deserialize(data, index + 1);
        treeNode.left = deserialize.value;
        Temp deserialize2 = deserialize(data, deserialize.index);
        treeNode.right = deserialize2.value;

        return new Temp(treeNode, deserialize2.index);
    }

    static class Temp {
        TreeNode value;
        int index;

        Temp(TreeNode value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
