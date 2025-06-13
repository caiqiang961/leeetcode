package org.tenxumainshi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2023-08-08 16:08
 **/
class Node {
    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    int value;
    Node left;
    Node right;
}

public class Main2 {

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(4, null, null), new Node(5, null, null)), new Node(3, null, null));
        forNodeMiddle(node);
        System.out.println();
        forNodeBefore(node);
        System.out.println();
        forNodeRight(node);
        System.out.println();
        forNodeGuangDu(node);
        System.out.println();
        forNodeShengDu(node);
    }

    //深度优先搜索 == 前序遍历
    private static void forNodeShengDu(Node header) {
        if (header == null) {
            return;
        }
        System.out.print(header.value + " ");
        forNodeShengDu(header.left);
        forNodeShengDu(header.right);

    }

    //广度优先搜索
    private static void forNodeGuangDu(Node header) {
        if (header == null) {
            return;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(header);

        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            System.out.print(node.value + " ");
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
    }

    //中序遍历
    private static void forNodeMiddle(Node header) {
        if (header == null) {
            return;
        }
        forNodeMiddle(header.left);

        System.out.print(header.value + " ");

        forNodeMiddle(header.right);

    }

    //前序遍历
    private static void forNodeBefore(Node header) {
        if (header == null) {
            return;
        }
        System.out.print(header.value + " ");
        forNodeBefore(header.left);
        forNodeBefore(header.right);

    }

    //后序遍历
    private static void forNodeRight(Node header) {
        if (header == null) {
            return;
        }
        forNodeRight(header.left);
        forNodeRight(header.right);
        System.out.print(header.value + " ");

    }

}
