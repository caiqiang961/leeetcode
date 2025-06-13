package org.caiqiang;

/**
 * @program: leetcode
 * @description:
 * @author: caiqiang
 * @create: 2022-03-15 18:25
 **/
public class Solution24 {
    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode header7 = new ListNode(2);
        ListNode header6 = new ListNode(2,header7);
        ListNode header5 = new ListNode(6,header6);
        ListNode header4 = new ListNode(4,header5);
        ListNode header3 = new ListNode(3,header4);
        ListNode header2 = new ListNode(5,header3);
        ListNode header = new ListNode(2,header2);
        System.out.println(solution24.swapPairs(header));
    }
    public ListNode swapPairs(ListNode head) {
        ListNode start = head;
        ListNode one = null;
        ListNode two = null;
        ListNode suffix = null;
        ListNode header = null;
        while (start != null){
            if (one == null){
                one = start;
            }else if (two == null){
                two = start;
            }
            if (one != null && two != null){
                start = start.next;
                if (suffix !=null){
                    suffix.next = two;
                    one.next = two.next;
                    two.next = one;
                    suffix = one;
                }else {
                    one.next = two.next;
                    two.next = one;
                    suffix = one;
                }


                if (header == null){
                    header = two;
                }
                one = null;
                two = null;
            }else {
                start = start.next;

            }
        }
        return header == null ? one : header;
    }
}
