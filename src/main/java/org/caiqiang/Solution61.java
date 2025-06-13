package org.caiqiang;

public class Solution61 {
    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
//        ListNode listNode = solution61.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        ListNode listNode = solution61.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    // 闭合为环,向后移动k个位置，则新的头部为倒数第k个，正数第n-k+1个
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) {
            return head;
        }
        if (head == null) {
            return null;
        }

        ListNode orgHead = head;
        ListNode end = null;
        int n = 0;
        while (head != null){
            if (head.next == null){
                end = head;
            }
            head = head.next;
            n++;
        }


        head = orgHead;
        if (k > n){
            k = k % n;
        }
        if (k==0){
            return head;
        }
        end.next = orgHead;

        ListNode newHead = null;
        ListNode preHead = end;
        for (int i = 1; i <= n; i++) {
          if (i == (n-k)+1){
              newHead = head;
              preHead.next = null;
          }
          preHead = head;
          head = head.next;
        }
        return newHead;
    }
}
