package org.caiqiang;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2022-03-08 17:56
 **/
public class Solution19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();


        ListNode header5 = new ListNode(5);
        ListNode header4 = new ListNode(4,header5);
        ListNode header3 = new ListNode(3,header4);
        ListNode header2 = new ListNode(2,header3);
        ListNode header = new ListNode(1,header2);
        System.out.println(solution19.removeNthFromEnd1(header, 5));
    }

    //双指针 + 前驱指针   一次遍历求解
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode one = head;
        ListNode two = null;
        ListNode suffix = null;

        int count = 1;
        while (one != null){

            if (two != null) {
                two = two.next;
            }
            if (count == n) {
                two = head;
            }
            if (count > n){
                if (count - n == 1){
                    suffix = head;
                }else {
                    suffix = suffix.next;
                }

            }

            one = one.next;
            count++;
        }
        if (suffix == null){
             head = head.next;
            return head;
        }
        if (two == null){
            return null;
        }
        suffix.next = two.next;
        return head;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> listNodes = new ArrayList<>();
        if (head == null) {
            return null;
        }
        ListNode listNode = head;
        listNodes.add(listNode.val);
        while (listNode.next != null) {
            listNode = listNode.next;
            listNodes.add(listNode.val);
        }
        if (n > listNodes.size()) {
            return head;
        }

        listNodes.remove(listNodes.size() - n);

        if (listNodes.size() == 0) {
            return null;
        }
        ListNode header = new ListNode();

        ListNode start = header;

        for (int i = 0; i < listNodes.size(); i++) {
            start.val = listNodes.get(i);
            if (i < listNodes.size() - 1) {
                start.next = new ListNode();
                start = start.next;
            }
        }


        return header;

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
